package update_order_status_use_case;

// Application Business Rules Layer

import database.MongoCollectionFetcher;
import database.OrderDataGateway;
import database.OrderDataProcessorMongo;
import org.bson.types.ObjectId;

public class UpdateOrderStatusInteractor implements UpdateOrderStatusInputBoundary {

    final UpdateOrderStatusPresenter presenter;


    public UpdateOrderStatusInteractor(UpdateOrderStatusPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public String getOrderStatus(ObjectId orderId) {
        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
        OrderDataGateway gateway = new OrderDataProcessorMongo(fetcher);
        return gateway.findById(orderId).getOrderStatus();
    }

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