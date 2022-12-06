package restaurant_order_history_use_case;

import java.awt.*;

public class RestaurantOrderHistoryProcessor implements RestaurantOrderHistoryPresenter {
    RestaurantOrderHistoryPanelInterface screen;

    public RestaurantOrderHistoryProcessor(RestaurantOrderHistoryPanelInterface screen) {
        this.screen = screen;
    }

    public void setOrders(RestaurantOrderHistoryResponseModel responseModel) {
        this.screen.setOrder(responseModel.getOrderInfo());
    }

    public RestaurantOrderHistoryPanelInterface getScreen() {
        return screen;
    }

    public void setScreen(RestaurantOrderHistoryPanelInterface screen) {
        this.screen = screen;
    }
    public void newOrder() {
        this.screen.showMessage("You have a new order!");
        this.screen.updateOrder();
    }
}
