package user_display_restaurants_use_case;

import org.bson.types.ObjectId;

import java.util.HashMap;

public interface UserDisplayRestaurantPanelInterface {
    void updateRestaurantPanel(HashMap<ObjectId, String> restaurantInfo);
    void refreshData();
}
