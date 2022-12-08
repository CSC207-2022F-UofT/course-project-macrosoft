package restaurant_order_history_use_case;
/*
processor of the restaurant order history use case
 */


public class RestaurantOrderHistoryProcessor implements RestaurantOrderHistoryPresenter {
    RestaurantOrderHistoryPanelInterface screen;

    public RestaurantOrderHistoryProcessor(RestaurantOrderHistoryPanelInterface screen) {
        this.screen = screen;
    }

    /**
     * set orders according to the response model
     * @param responseModel response model
     */
    public void setOrders(RestaurantOrderHistoryResponseModel responseModel) {
        this.screen.setOrder(responseModel.getOrderInfo());
    }

    /**
     * return the current screen
     * @return this screen
     */
    public RestaurantOrderHistoryPanelInterface getScreen() {
        return screen;
    }

    /**
     * set the current screen
     * @param screen  new screen
     */
    public void setScreen(RestaurantOrderHistoryPanelInterface screen) {
        this.screen = screen;
    }

    /**
     * show a message when there is a new order comming to the current restaurant.
     */
    public void newOrder() {
        this.screen.showMessage("You have a new order!");
        this.screen.updateOrder();
    }
}
