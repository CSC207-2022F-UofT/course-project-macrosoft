package update_order_status_use_case;

// Application Business Rule Layer

import org.bson.types.ObjectId;

public class UpdateOrderStatusRequestModel {

    private ObjectId orderId;
    private String newStatus;

    public UpdateOrderStatusRequestModel(ObjectId orderId, String newStatus) {
        this.orderId = orderId;
        this.newStatus = newStatus;
    }

    public ObjectId getCurOrderId() {return this.orderId;}

    public String getNewStatus() {return this.newStatus;}









}
