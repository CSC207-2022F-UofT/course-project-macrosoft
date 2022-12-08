package restaurant_profile_use_case;

import entities.Restaurant;
import org.bson.types.ObjectId;

/**
 * This class is the request model for the restaurant profile use case.
 */
public class RestaurantProfileRequestModel {
    ObjectId restaurantID;

    /**
     * Constructor for RestaurantProfileRequestModel
     *
     * @param restaurantID the restaurant id
     */
    public RestaurantProfileRequestModel(ObjectId restaurantID) {
        this.restaurantID = restaurantID;
    }

    /**
     * Gets the restaurant id.
     *
     * @return the restaurant id
     */
    public ObjectId getRestaurantID() {
        return restaurantID;
    }
}
