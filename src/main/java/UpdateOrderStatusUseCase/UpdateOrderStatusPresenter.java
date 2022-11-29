package UpdateOrderStatusUseCase;

// Interface Adaptors Layer

public interface UpdateOrderStatusPresenter {

    UpdateOrderStatusResponseModel prepareSuccessView(UpdateOrderStatusResponseModel responsModel);

    UpdateOrderStatusResponseModel prepareFailView(String str);



}
