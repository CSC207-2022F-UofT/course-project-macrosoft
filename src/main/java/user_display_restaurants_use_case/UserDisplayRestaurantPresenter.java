package user_display_restaurants_use_case;

import org.bson.types.ObjectId;

import java.util.HashMap;

/**
 * This class is the processor of the user display restaurants use case.
 */
public class UserDisplayRestaurantPresenter implements UserDisplayRestaurantOutputBoundary {
    UserDisplayRestaurantPanelInterface screen;

    /**
     * Constructor for UserDisplayRestaurantPresenter
     *
     * @param screen UserDisplayRestaurantPanelInterface screen
     */
    public UserDisplayRestaurantPresenter(UserDisplayRestaurantPanelInterface screen) {
        this.screen = screen;
    }

    /**
     * Sets the current screen
     *
     * @param screen screen
     */
    public void setScreen(UserDisplayRestaurantPanelInterface screen) {
        this.screen = screen;
    }

    /**
     * Display the restaurants given the restaurant information
     *
     * @param restaurantInfo a hashmap that maps object id (restaurant id)to string(restaurant name)
     */
    public void displayRestaurants(HashMap<ObjectId, String> restaurantInfo) {
        this.screen.updateRestaurantPanel(restaurantInfo);
    }
}
