package restaurant_profile_use_case;

import org.bson.types.ObjectId;

public class RestaurantProfileController {
    private RestaurantProfileInputBoundary restaurantProfileInteractor;
    private ObjectId currentRestaurantId;

    public RestaurantProfileController(RestaurantProfileInputBoundary restaurantProfileInteractor, ObjectId currentRestaurantId) {
        this.restaurantProfileInteractor = restaurantProfileInteractor;
        this.currentRestaurantId = currentRestaurantId;
    }

    public void getRestaurantProfile() {
        if (this.currentRestaurantId == null) return;

        RestaurantProfileRequestModel restaurantProfileRequestModel = new RestaurantProfileRequestModel(this.currentRestaurantId);
        restaurantProfileInteractor.displayRestaurantProfile(restaurantProfileRequestModel);
    }

    public ObjectId getCurrentRestaurantId() {
        return currentRestaurantId;
    }
}
