package orderhistoryusecase;

public interface OrderHistoryPresenter {
    OrderHistoryResponseModel getSuccess(OrderHistoryResponseModel response);
    OrderHistoryResponseModel getFail(OrderHistoryResponseModel response);
}
