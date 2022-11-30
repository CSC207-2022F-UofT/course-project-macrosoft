package OrderHistoryUseCase;

import Database.OrderDataGateway;
import Entities.Order;
import Entities.User;

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

    @Override
    public OrderHistoryResponseModel getOrders(OrderHistoryRequestModel requestModel) {
        List<Order> orderList = orderDataGateway.findAllByUser(requestModel.getCurUser().getUserId());
        OrderHistoryResponseModel responseModel = new OrderHistoryResponseModel(orderList);
        return responseModel;
    }

    @Override
    public User getCurUser() {
        return user;
    }
}
