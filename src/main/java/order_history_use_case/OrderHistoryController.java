package order_history_use_case;

import entities.User;

public class OrderHistoryController {
    private final OrderHistoryInputBoundary orderHistoryInput;

    public OrderHistoryController(OrderHistoryInputBoundary orderHistoryInput) {
        this.orderHistoryInput = orderHistoryInput;
    }

    public OrderHistoryResponseModel getOrders(User user) {
        OrderHistoryRequestModel requestModel = new OrderHistoryRequestModel(user);

        return orderHistoryInput.getOrders(requestModel);
    }

    public OrderHistoryInputBoundary getOrderHistoryInput() {
        return orderHistoryInput;
    }
}
