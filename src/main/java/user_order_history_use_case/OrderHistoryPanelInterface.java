package user_order_history_use_case;
/*
Interface of the screen
 */
public interface OrderHistoryPanelInterface {
    void updateOrder();

    void setOrder(OrderHistoryResponseModel orderHistoryResponseModel);
}
