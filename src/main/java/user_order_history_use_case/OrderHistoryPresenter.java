package user_order_history_use_case;



/**
 * This interface is the order history presenter for the order history use case
 */
public interface OrderHistoryPresenter {

    /**
     * Display the orders when the correct orders were found
     *
     * @param orderHistoryResponseModel An instance of order history response model
     */
    void orderFound(OrderHistoryResponseModel orderHistoryResponseModel);

    /**
     * Display when the orders were not correctly found
     */
    void orderNotFound();

    /**
     * Set the order history panel to the given panel
     *
     * @param orderHistoryPanel An order history panel object
     */
    void setOrderHistoryPanel(OrderHistoryPanelInterface orderHistoryPanel);
}
