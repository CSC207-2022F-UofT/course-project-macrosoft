package restaurant_profile_use_case;

import user_profile_use_case.UserProfilePanelInterface;
import user_profile_use_case.UserProfileResponseModel;

public interface RestaurantProfilePresenter {
    void setRestaurantProfilePanel(RestaurantProfilePanelInterface restaurantProfilePanel);
    void restaurantNotFound();
    void restaurantFound(RestaurantProfileResponseModel restaurantProfileResponseModel);
}
