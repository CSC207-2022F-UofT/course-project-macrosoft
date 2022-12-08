package update_order_status_use_case;

// Interface Adaptors Layer

import org.bson.types.ObjectId;

/**
 * This class is the controller for update order status use case.
 */
public class UpdateOrderStatusController {

    final UpdateOrderStatusInputBoundary updateInteractor;

    private final ObjectId orderId;

    /**
     * Constructor for UpdateOrderStatusController
     *
     * @param updateInteractor the update order status interactor
     * @param orderId          ObjectId order id of current order
     */
    public UpdateOrderStatusController(UpdateOrderStatusInputBoundary updateInteractor, ObjectId orderId) {
        this.updateInteractor = updateInteractor;
        this.orderId = orderId;
    }

    /**
     * Update order status of current order with new order status
     *
     * @param newStatus String new order status
     */
    public void updateOrderStatus(String newStatus) {
        UpdateOrderStatusRequestModel request = new UpdateOrderStatusRequestModel(orderId, newStatus);

        updateInteractor.updateOrderStatus(request);
    }

    /**
     * Get current order ID
     *
     * @return ObjectId current order ID
     */
    public ObjectId getOrderId() {
        return orderId;
    }

    /**
     * Get current status input / update interactor
     *
     * @return UpdateOrderStatusInputBoundary interactor of current order
     */

    public UpdateOrderStatusInputBoundary getStatusInput() {
        return updateInteractor;
    }
}
