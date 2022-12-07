package update_order_status_use_case;

// Interface Adaptors Layer

import org.bson.types.ObjectId;

public class UpdateOrderStatusController {

    final UpdateOrderStatusInputBoundary updateInteractor;

    private ObjectId orderId;

    public UpdateOrderStatusController(UpdateOrderStatusInputBoundary updateInteractor, ObjectId orderId) {
        this.updateInteractor = updateInteractor;
        this.orderId = orderId;
    }

    public void updateOrderStatus(String newStatus) {
        UpdateOrderStatusRequestModel request = new UpdateOrderStatusRequestModel(orderId, newStatus);

        updateInteractor.updateOrderStatus(request);
    }

//    public void updateOrderStatus(ObjectId orderId ,String newStatus) {
//        this.updateInteractor.updateOrderStatus(orderId, newStatus);
//    }

    public ObjectId getOrderId() {
        return orderId;
    }

    public UpdateOrderStatusInputBoundary getStatusInput() {
        return updateInteractor;
    }


}
