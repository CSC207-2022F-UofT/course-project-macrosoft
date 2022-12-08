package restaurant_order_history_use_case;
/*
presenter of the restaurant order history use case.
 */
public interface RestaurantOrderHistoryPresenter {
    void setScreen(RestaurantOrderHistoryPanelInterface screen);
    void setOrders(RestaurantOrderHistoryResponseModel responseModel);
    void newOrder();
}
