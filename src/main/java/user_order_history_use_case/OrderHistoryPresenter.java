package user_order_history_use_case;

public interface OrderHistoryPresenter {
    void orderFound(OrderHistoryResponseModel orderHistoryResponseModel);
    void orderNotFound();
    void setOrderHistoryPanel(OrderHistoryPanelInterface orderHistoryPanel);
}
