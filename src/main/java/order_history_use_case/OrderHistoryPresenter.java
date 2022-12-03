package order_history_use_case;

public interface OrderHistoryPresenter {
    OrderHistoryResponseModel getSuccess(OrderHistoryResponseModel response);
    OrderHistoryResponseModel getFail(OrderHistoryResponseModel response);
}
