package OrderHistoryUseCase;

public interface OrderHistoryInputBoundary {
    public OrderHistoryResponseModel getOrders(OrderHistoryRequestModel requestModel);
}
