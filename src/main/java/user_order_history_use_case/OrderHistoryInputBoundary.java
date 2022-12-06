package user_order_history_use_case;

import org.bson.types.ObjectId;

public interface OrderHistoryInputBoundary {
    void displayOrders(OrderHistoryRequestModel requestModel);

    OrderHistoryResponseModel getResponse(ObjectId userId);

}
