package restaurant_profile_use_case;

public interface RestaurantProfilePresenter {
    void setRestaurantProfilePanel(RestaurantProfilePanelInterface restaurantProfilePanel);
    void restaurantNotFound();
    void restaurantFound(RestaurantProfileResponseModel restaurantProfileResponseModel);
}
