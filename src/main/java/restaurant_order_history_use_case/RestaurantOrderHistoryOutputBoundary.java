package restaurant_order_history_use_case;

/**
 * presenter of the restaurant order history use case.
 */
public interface RestaurantOrderHistoryOutputBoundary {
    /**
     * Presents the screen.
     *
     * @param screen the screen
     */
    void setScreen(RestaurantOrderHistoryPanelInterface screen);

    /**
     * Sets the orders.
     *
     * @param responseModel the response model
     */
    void setOrders(RestaurantOrderHistoryResponseModel responseModel);

    /**
     * new order.
     */
    void newOrder();
}
