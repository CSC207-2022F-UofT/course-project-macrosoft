package DataModels;

import org.bson.types.ObjectId;

public class IdGetOrderRequestModel {
    private ObjectId orderId;

    public IdGetOrderRequestModel(ObjectId orderId) {
        this.orderId = orderId;
    }

    public ObjectId getOrderId() {
        return orderId;
    }

    public void setOrderId(ObjectId orderId) {
        this.orderId = orderId;
    }
}
