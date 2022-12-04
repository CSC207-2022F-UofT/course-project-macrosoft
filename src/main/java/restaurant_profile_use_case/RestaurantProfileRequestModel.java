package restaurant_profile_use_case;

import entities.Restaurant;
import org.bson.types.ObjectId;

public class RestaurantProfileRequestModel {
    ObjectId restaurantID;
    public RestaurantProfileRequestModel(ObjectId restaurantID){
        this.restaurantID = restaurantID;
    }

    public ObjectId getRestaurantID() {
        return restaurantID;
    }
}
