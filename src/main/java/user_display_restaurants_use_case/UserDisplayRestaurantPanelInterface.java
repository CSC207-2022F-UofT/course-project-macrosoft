package user_display_restaurants_use_case;

import org.bson.types.ObjectId;

import java.util.HashMap;

/**
 * interface of the panel
 */
public interface UserDisplayRestaurantPanelInterface {
    /**
     * Updates restaurant panel
     *
     * @param restaurantInfo restaurant info
     */
    void updateRestaurantPanel(HashMap<ObjectId, String> restaurantInfo);

    /**
     * Refreshes data
     */
    void refreshData();
}
