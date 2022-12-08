package user_order_history_use_case;

/**
 * presenter of the use case
 */
public interface OrderHistoryPresenter {
    /**
     * Find the order.
     *
     * @param orderHistoryResponseModel the order history response model
     */
    void orderFound(OrderHistoryResponseModel orderHistoryResponseModel);

    /**
     * Order not found.
     */
    void orderNotFound();

    /**
     * Sets order history panel.
     *
     * @param orderHistoryPanel the order history panel
     */
    void setOrderHistoryPanel(OrderHistoryPanelInterface orderHistoryPanel);
}
