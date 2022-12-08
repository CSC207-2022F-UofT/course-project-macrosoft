package user_display_restaurants_use_case;

import org.bson.types.ObjectId;

import java.util.HashMap;

/**
 * presenter of the usecase
 */
public interface UserDisplayRestaurantPresenter {
    /**
     * Sets the screen
     *
     * @param screen the screen
     */
    void setScreen(UserDisplayRestaurantPanelInterface screen);

    /**
     * Displays restaurants
     *
     * @param restaurantInfo restaurant info
     */
    void displayRestaurants(HashMap<ObjectId, String> restaurantInfo);
}
