package OrderHistoryUseCase;

import Database.OrderDataGateway;
import Entities.Order;
import Entities.User;
import org.bson.types.ObjectId;

import java.util.List;

public class OrderHistoryInteractor implements OrderHistoryInputBoundary {


    private final OrderHistoryPresenter presenter;
    private final OrderDataGateway orderDataGateway;
    private final User user;

    public OrderHistoryInteractor(OrderHistoryPresenter presenter, OrderDataGateway orderDataGateway, User user) {
        this.presenter = presenter;
        this.orderDataGateway = orderDataGateway;
        this.user = user;
    }
    public OrderHistoryResponseModel getOrders(OrderHistoryRequestModel requestModel) {
        ObjectId userId = requestModel.getCurUser().getUserId();
        List<Order> orderHistory =  orderDataGateway.findAllByUser(userId);

        OrderHistoryResponseModel orderHistoryResponseModel = new OrderHistoryResponseModel(orderHistory);
        return presenter.getSuccess(orderHistoryResponseModel);
    }

    @Override
    public User getUser() {
        return user;
    }
}
