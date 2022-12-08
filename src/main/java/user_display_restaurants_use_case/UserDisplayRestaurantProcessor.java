package user_display_restaurants_use_case;

import org.bson.types.ObjectId;

import java.util.HashMap;

public class UserDisplayRestaurantProcessor implements UserDisplayRestaurantPresenter {
    UserDisplayRestaurantPanelInterface screen;

    public UserDisplayRestaurantProcessor(UserDisplayRestaurantPanelInterface screen) {
        this.screen = screen;
    }

    /**
     * set the current screen
     * @param screen screen
     */
    public void setScreen(UserDisplayRestaurantPanelInterface screen) {
        this.screen = screen;
    }

    /**
     * display the restaurants given the restaurant information
     * @param restaurantInfo a hashmap that maps object id (restaurant id)to string(restaurant name)
     */
    public void displayRestaurants(HashMap<ObjectId, String> restaurantInfo) {
        this.screen.updateRestaurantPanel(restaurantInfo);
    }
}
