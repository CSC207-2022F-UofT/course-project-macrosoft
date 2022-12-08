package restaurant_profile_use_case;

/**
 * This interface is the input boundary for the restaurant profile use case.
 */
public interface RestaurantProfileInputBoundary {
    /**
     * Displays the restaurant profile.
     *
     * @param restaurantProfileRequestModel the request model
     */
    void displayRestaurantProfile(RestaurantProfileRequestModel restaurantProfileRequestModel);
}
