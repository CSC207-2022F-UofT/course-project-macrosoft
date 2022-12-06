package update_order_status_use_case;

// Interface Adaptors Layer

import org.bson.types.ObjectId;

public class UpdateOrderStatusController {

    final UpdateOrderStatusInputBoundary StatusInput;
    private ObjectId currentOrderId;

    public UpdateOrderStatusController(UpdateOrderStatusInputBoundary statusInput, ObjectId currentOrderId) {
        this.StatusInput = statusInput;
        this.currentOrderId = currentOrderId;
    }

    public void updateOrderStatus(String newStatus) {
        UpdateOrderStatusRequestModel requestModel =
                new UpdateOrderStatusRequestModel(currentOrderId, newStatus);
        StatusInput.updateOrderStatus(requestModel);
    }

    public UpdateOrderStatusInputBoundary getStatusInput() {
        return StatusInput;
    }

    public ObjectId getCurrentOrderId() {
        return currentOrderId;
    }
}
