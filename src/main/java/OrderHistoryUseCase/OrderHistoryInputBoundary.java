package OrderHistoryUseCase;

import Entities.User;

public interface OrderHistoryInputBoundary {
    OrderHistoryResponseModel getOrders(OrderHistoryRequestModel requestModel);

    User getCurUser();
}
