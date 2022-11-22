package OrderHistoryUseCase;

import org.bson.types.ObjectId;

public class OrderHistoryController {
    final OrderHistoryInputBoundary userInput;

    public OrderHistoryController(OrderHistoryInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    public OrderHistoryResponseModel getOrders(ObjectId userId) {
        OrderHistoryRequestModel requestModel = new OrderHistoryRequestModel(userId);

        return userInput.getOrders(requestModel);
    }
}
