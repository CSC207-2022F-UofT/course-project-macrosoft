package restaurant_register_use_case;

public class RegisterRestaurantController {
    private RegisterRestaurantInputBoundary interactor;

    public RegisterRestaurantController(RegisterRestaurantInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void register(String restaurantName, String username, String password, String email, String location, String phone) {
        RegisterRestaurantRequestModel requestModel = new RegisterRestaurantRequestModel(restaurantName, username, password, email, location, phone);
        this.interactor.registerRestaurant(requestModel);
    }
}
