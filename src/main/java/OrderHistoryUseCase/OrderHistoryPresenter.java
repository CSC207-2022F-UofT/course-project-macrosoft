package OrderHistoryUseCase;

public interface OrderHistoryPresenter {
    OrderHistoryResponseModel getSuccess(OrderHistoryResponseModel response);
    OrderHistoryResponseModel getFail(OrderHistoryResponseModel response);
}
