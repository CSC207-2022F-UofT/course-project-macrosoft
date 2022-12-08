package update_order_status_use_case;

// Application Business Rule Layer

import org.bson.types.ObjectId;

/**
 * This class is the request model of the update order status use case.
 */
public class UpdateOrderStatusRequestModel {

    private final ObjectId orderId;
    private final String newStatus;

    /**
     * Constructor for UpdateOrderStatusRequestModel
     *
     * @param orderId   ObjectId order id of current order
     * @param newStatus String new order status of current order
     */
    public UpdateOrderStatusRequestModel(ObjectId orderId, String newStatus) {
        this.orderId = orderId;
        this.newStatus = newStatus;
    }

    /**
     * Get current order id
     *
     * @return ObjectId current order id
     */
    public ObjectId getCurOrderId() {
        return this.orderId;
    }

    /**
     * Get new order status of current order
     *
     * @return String new order status
     */
    public String getNewStatus() {
        return this.newStatus;
    }


}
