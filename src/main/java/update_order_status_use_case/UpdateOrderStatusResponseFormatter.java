package update_order_status_use_case;

// Interface adapter layer

public class UpdateOrderStatusResponseFormatter implements UpdateOrderStatusPresenter{

    @Override
    public UpdateOrderStatusResponseModel prepareSuccessView(UpdateOrderStatusResponseModel response) {
        return response;
    }

    @Override
    public UpdateOrderStatusResponseModel prepareFailView(String str) {
        return null;
    }
}
