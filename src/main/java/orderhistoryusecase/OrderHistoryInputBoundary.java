package orderhistoryusecase;

import entities.User;

public interface OrderHistoryInputBoundary {
    OrderHistoryResponseModel getOrders(OrderHistoryRequestModel requestModel);

    User getCurUser();
}
