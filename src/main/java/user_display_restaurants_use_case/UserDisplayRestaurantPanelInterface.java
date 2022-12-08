package user_display_restaurants_use_case;
/*
interface of the panel
 */
import org.bson.types.ObjectId;

import java.util.HashMap;

public interface UserDisplayRestaurantPanelInterface {
    void updateRestaurantPanel(HashMap<ObjectId, String> restaurantInfo);
    void refreshData();
}
