package user_display_restaurants_use_case;
/*
presenter of the usecase
 */
import org.bson.types.ObjectId;

import java.util.HashMap;

public interface UserDisplayRestaurantPresenter {
    void setScreen(UserDisplayRestaurantPanelInterface screen);
    void displayRestaurants(HashMap<ObjectId, String> restaurantInfo);
}
