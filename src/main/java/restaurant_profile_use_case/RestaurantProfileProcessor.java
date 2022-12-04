package restaurant_profile_use_case;

public class RestaurantProfileProcessor implements RestaurantProfilePresenter{

    RestaurantProfilePanelInterface restaurantProfilePanel;
    @Override
    public void setRestaurantProfilePanel(RestaurantProfilePanelInterface restaurantProfilePanel) {
        this.restaurantProfilePanel = restaurantProfilePanel;
    }

    @Override
    public void restaurantNotFound() {

    }

    @Override
    public void restaurantFound(RestaurantProfileResponseModel restaurantProfileResponseModel) {
        restaurantProfilePanel.updateNameLabel(restaurantProfileResponseModel.getName());
        restaurantProfilePanel.updateEmailLabel(restaurantProfileResponseModel.getEmail());
        restaurantProfilePanel.updateLocationLabel(restaurantProfileResponseModel.getLocation());
        restaurantProfilePanel.updatePhoneLabel(restaurantProfileResponseModel.getPhone());
    }
}
