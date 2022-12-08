package update_order_status_use_case;

// Application Business Rules Layer

import database.MongoCollectionFetcher;
import database.OrderDataGateway;
import database.OrderDataProcessorMongo;
import org.bson.types.ObjectId;

/**
 * This class is the interactor of the update order status use case.
 */
public class UpdateOrderStatusInteractor implements UpdateOrderStatusInputBoundary {

    final UpdateOrderStatusPresenter presenter;

    /**
     * Constructor for UpdateOrderStatusInteractor
     *
     * @param presenter UpdateOrderStatusPresenter the update order status presenter
     */
    public UpdateOrderStatusInteractor(UpdateOrderStatusPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Get the order status with given orderId
     *
     * @param orderId ObjectId  order ID that is used to track a specific order
     * @return String order status of the current order
     */
    @Override
    public String getOrderStatus(ObjectId orderId) {
        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
        OrderDataGateway gateway = new OrderDataProcessorMongo(fetcher);
        return gateway.findById(orderId).getOrderStatus();
    }

    /**
     * Update order status of the order
     *
     * @param request UpdateOrderStatusRequestModel the update order status request model
     */
    @Override
    public void updateOrderStatus(UpdateOrderStatusRequestModel request) {
        try {
            MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
            OrderDataGateway gateway = new OrderDataProcessorMongo(fetcher);
            gateway.updateStatus(request.getCurOrderId(), request.getNewStatus());
            this.presenter.prepareSuccessView();
        } catch (Exception e) {
            presenter.prepareFailView("Failed");
        }
    }
}