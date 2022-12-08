package restaurant_profile_use_case;


public class RestaurantProfileProcessor implements RestaurantProfilePresenter{

    private RestaurantProfilePanelInterface restaurantProfilePanel;

    public RestaurantProfileProcessor(RestaurantProfilePanelInterface restaurantProfilePanel) {
        this.restaurantProfilePanel = restaurantProfilePanel;
    }

    /**
     * set the panel
     * @param restaurantProfilePanel new panel
     */
    @Override
    public void setRestaurantProfilePanel(RestaurantProfilePanelInterface restaurantProfilePanel) {
        this.restaurantProfilePanel = restaurantProfilePanel;
    }

    /**
     * when the restaurant is not found, don't do anything
     */
    @Override
    public void restaurantNotFound() {

    }

    /**
     * update the restaurant information when the restaurant is found
     * @param restaurantProfileResponseModel response model
     */
    @Override
    public void restaurantFound(RestaurantProfileResponseModel restaurantProfileResponseModel) {
        restaurantProfilePanel.updateNameLabel(restaurantProfileResponseModel.getName());
        restaurantProfilePanel.updateEmailLabel(restaurantProfileResponseModel.getEmail());
        restaurantProfilePanel.updateLocationLabel(restaurantProfileResponseModel.getLocation());
        restaurantProfilePanel.updatePhoneLabel(restaurantProfileResponseModel.getPhone());
    }
}
