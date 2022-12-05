package restaurant_homepage_use_case;

import org.bson.types.ObjectId;

public class RestaurantHomepageController {
    ObjectId currentRestaurantId;

    public RestaurantHomepageController(ObjectId currentRestaurantId) {
        this.currentRestaurantId = currentRestaurantId;
    }

}
