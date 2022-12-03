package update_order_status_use_case;

// Interface Adaptors Layer

public interface UpdateOrderStatusPresenter {

    UpdateOrderStatusResponseModel prepareSuccessView(UpdateOrderStatusResponseModel responsModel);

    UpdateOrderStatusResponseModel prepareFailView(String str);



}
