package orderhistoryusecase;

public class OrderHistoryProcessor implements OrderHistoryPresenter{
    @Override
    public OrderHistoryResponseModel getFail(OrderHistoryResponseModel response) {
        return response;
    }

    @Override
    public OrderHistoryResponseModel getSuccess(OrderHistoryResponseModel response) {
        return response;
    }
}
