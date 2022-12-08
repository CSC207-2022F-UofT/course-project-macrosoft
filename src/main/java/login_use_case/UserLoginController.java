package login_use_case;

/**
 * This class is the controller for the user login use case.
 */
public class UserLoginController {

    final UserLoginInputBoundary userInput;
    final RestaurantLoginInputBoundary restaurantInput;

    /**
     * Constructor for UserLoginController
     *
     * @param userInput       the user input
     * @param restaurantInput the restaurant input
     */
    public UserLoginController(UserLoginInputBoundary userInput, RestaurantLoginInputBoundary restaurantInput) {
        this.userInput = userInput;
        this.restaurantInput = restaurantInput;
    }

    /**
     * Login the user
     *
     * @param username the username
     * @param password the password
     */
    public UserLoginResponseModel login(String username, String password) {
        UserLoginRequestModel requestModel = new UserLoginRequestModel(
                username, password);

        return userInput.login(requestModel);
    }

    /**
     * Login the restaurant
     *
     * @param username the username
     * @param password the password
     */
    public UserLoginResponseModel loginAsRestaurant(String username, String password) {
        RestaurantLoginRequestModel requestModel = new RestaurantLoginRequestModel(
                username, password);

        return restaurantInput.login(requestModel);
    }
}
