package restaurant_order_history_use_case;

public interface RestaurantOrderHistoryPresenter {
    void setScreen(RestaurantOrderHistoryPanelInterface screen);
    void setOrders(RestaurantOrderHistoryResponseModel responseModel);

}
