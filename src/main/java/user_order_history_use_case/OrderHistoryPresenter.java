package user_order_history_use_case;
/*
presenter of the use case
 */
public interface OrderHistoryPresenter {
    void orderFound(OrderHistoryResponseModel orderHistoryResponseModel);
    void orderNotFound();
    void setOrderHistoryPanel(OrderHistoryPanelInterface orderHistoryPanel);
}
