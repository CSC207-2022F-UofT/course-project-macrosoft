package change_restaurant_info_use_case;

/**
 * This interface is the input boundary for the change restaurant information use case.
 */
public interface ChangeRestaurantInfoInputBoundary {
    /**
     * Change the restaurant information
     *
     * @param requestModel the request model
     */
    void changeRestaurantInfo(ChangeRestaurantInfoRequestModel requestModel);
}
