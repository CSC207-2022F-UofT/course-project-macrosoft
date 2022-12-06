package update_order_status_use_case;

// Interface Adaptors Layer

import org.bson.types.ObjectId;

public class UpdateOrderStatusController {

    final UpdateOrderStatusInputBoundary interactor;

    public UpdateOrderStatusController(UpdateOrderStatusInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void updateOrderStatus(ObjectId orderId ,String newStatus) {
        interactor.updateOrderStatus(orderId, newStatus);
    }

    public UpdateOrderStatusInputBoundary getStatusInput() {
        return interactor;
    }


}
