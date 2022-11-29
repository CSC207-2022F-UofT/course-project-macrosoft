package UpdateOrderStatusUseCase;

// Interface Adaptors Layer

public class UpdateOrderStatusController {

    final UpdateOrderStatusInputBoundary StatusInput;

    public UpdateOrderStatusController(UpdateOrderStatusInputBoundary StatusInput) {
        this.StatusInput = StatusInput;
    }

    public UpdateOrderStatusResponseModel create(String newStatus) {
        UpdateOrderStatusRequestModel requestModel =
                new UpdateOrderStatusRequestModel(StatusInput.getCurOrder(), newStatus);
        return StatusInput.create(requestModel);
    }

    public UpdateOrderStatusInputBoundary getStatusInput() {
        return StatusInput;
    }


}
