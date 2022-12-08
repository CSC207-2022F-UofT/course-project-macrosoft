package restaurant_profile_use_case;

/**
 * presenter of the restaurant profile use case.
 */
public interface RestaurantProfilePresenter {
    /**
     * Sets the restaurant profile panel.
     *
     * @param restaurantProfilePanel the restaurant profile panel
     */
    void setRestaurantProfilePanel(RestaurantProfilePanelInterface restaurantProfilePanel);

    /**
     * Doesn't find the restaurant.
     */
    void restaurantNotFound();

    /**
     * Finds the restaurant.
     *
     * @param restaurantProfileResponseModel the response model
     */
    void restaurantFound(RestaurantProfileResponseModel restaurantProfileResponseModel);
}
