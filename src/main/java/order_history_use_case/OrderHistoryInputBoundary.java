package order_history_use_case;

import entities.User;

public interface OrderHistoryInputBoundary {
    OrderHistoryResponseModel getOrders(OrderHistoryRequestModel requestModel);

    User getCurUser();
}
