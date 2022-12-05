package login_use_case;

public class UserLoginController {

    final UserLoginInputBoundary userInput;
    final RestaurantLoginInputBoundary restaurantInput;

    public UserLoginController(UserLoginInputBoundary userInput, RestaurantLoginInputBoundary restaurantInput) {
        this.userInput = userInput;
        this.restaurantInput = restaurantInput;
    }

    public UserLoginResponseModel login(String username, String password) {
        UserLoginRequestModel requestModel = new UserLoginRequestModel(
                username, password);

        return userInput.login(requestModel);
    }

    public UserLoginResponseModel loginAsRestaurant(String username, String password) {
        RestaurantLoginRequestModel requestModel = new RestaurantLoginRequestModel(
                username, password);

        return restaurantInput.login(requestModel);
    }
}
