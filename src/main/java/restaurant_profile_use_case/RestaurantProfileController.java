package restaurant_profile_use_case;

import org.bson.types.ObjectId;

/**
 * This class is the controller for the restaurant profile use case.
 */
public class RestaurantProfileController {
    private final RestaurantProfileInputBoundary restaurantProfileInteractor;
    private final ObjectId currentRestaurantId;

    /**
     * Constructor for RestaurantProfileController
     *
     * @param restaurantProfileInteractor the restaurant profile interactor
     * @param currentRestaurantId         the current restaurant id
     */
    public RestaurantProfileController(RestaurantProfileInputBoundary restaurantProfileInteractor, ObjectId currentRestaurantId) {
        this.restaurantProfileInteractor = restaurantProfileInteractor;
        this.currentRestaurantId = currentRestaurantId;
    }

    /**
     * Gets the restaurant profile for the current restaurant.
     */
    public void getRestaurantProfile() {
        if (this.currentRestaurantId == null) return;

        RestaurantProfileRequestModel restaurantProfileRequestModel = new RestaurantProfileRequestModel(this.currentRestaurantId);
        restaurantProfileInteractor.displayRestaurantProfile(restaurantProfileRequestModel);
    }

    /**
     * Gets the id of the current restaurant.
     *
     * @return the id of the current restaurant
     */
    public ObjectId getCurrentRestaurantId() {
        return currentRestaurantId;
    }
}
