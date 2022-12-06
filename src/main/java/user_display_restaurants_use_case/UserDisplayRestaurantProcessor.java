package user_display_restaurants_use_case;

import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.Objects;

public class UserDisplayRestaurantProcessor implements UserDisplayRestaurantPresenter {
    UserDisplayRestaurantPanelInterface screen;

    public UserDisplayRestaurantProcessor(UserDisplayRestaurantPanelInterface screen) {
        this.screen = screen;
    }

    public void setScreen(UserDisplayRestaurantPanelInterface screen) {
        this.screen = screen;
    }

    public void displayRestaurants(HashMap<ObjectId, String> restaurantInfo) {
        this.screen.updateRestaurantPanel(restaurantInfo);
    }
}
