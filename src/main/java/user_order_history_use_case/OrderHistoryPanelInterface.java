package user_order_history_use_case;


/**
 * This is the order history panel interface for the order history use case
 */
public interface OrderHistoryPanelInterface {

    /**
     * Get updates of the order history
     */
    void updateOrder();


    /**
     * set the order panel
     *
     * @param orderHistoryResponseModel response model
     */
    void setOrder(OrderHistoryResponseModel orderHistoryResponseModel);
}
