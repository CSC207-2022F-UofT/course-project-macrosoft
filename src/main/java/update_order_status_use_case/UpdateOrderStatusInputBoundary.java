package update_order_status_use_case;

//Application Business Rule layer

import org.bson.types.ObjectId;

/**
 * This interface is the input boundary for the update order status use case.
 */
public interface UpdateOrderStatusInputBoundary {

    /**
     * This method is the input boundary for the update order status use case.
     *
     * @param request the update order status request model
     */
    void updateOrderStatus(UpdateOrderStatusRequestModel request);

    /**
     * Get order status with the given order ID.
     *
     * @param orderID ObjectId order ID of the current order
     * @return String order status of the current order
     */
    String getOrderStatus(ObjectId orderID);


}
