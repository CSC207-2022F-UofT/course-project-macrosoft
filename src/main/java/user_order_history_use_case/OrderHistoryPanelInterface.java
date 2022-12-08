package user_order_history_use_case;

/**
 * Interface of the screen
 */
public interface OrderHistoryPanelInterface {
    /**
     * Updates the order
     */
    void updateOrder();

    /**
     * Sets the order
     *
     * @param orderHistoryResponseModel the order history response model
     */
    void setOrder(OrderHistoryResponseModel orderHistoryResponseModel);
}
