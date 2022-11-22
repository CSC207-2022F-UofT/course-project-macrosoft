package OrderHistoryUseCase;

public interface OrderHistoryPresenter {
    public OrderHistoryResponseModel getSuccess(OrderHistoryResponseModel response);
    public OrderHistoryResponseModel getFail(OrderHistoryResponseModel response);
}
