package restaurant_register_use_case;

/**
 * This interface is the input boundary for the restaurant register use case.
 */
public interface RegisterRestaurantInputBoundary {
    /**
     * Registers a restaurant.
     *
     * @param requestModel the request model
     */
    void registerRestaurant(RegisterRestaurantRequestModel requestModel);
}
