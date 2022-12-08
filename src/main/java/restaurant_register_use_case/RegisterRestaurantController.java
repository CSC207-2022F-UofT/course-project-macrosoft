package restaurant_register_use_case;

/**
 * This class is the controller for the restaurant register use case.
 */
public class RegisterRestaurantController {
    private final RegisterRestaurantInputBoundary interactor;

    /**
     * Constructor for RegisterRestaurantController
     *
     * @param interactor the interactor
     */
    public RegisterRestaurantController(RegisterRestaurantInputBoundary interactor) {
        this.interactor = interactor;
    }

    /**
     * Registers a restaurant.
     *
     * @param restaurantName the restaurant name
     * @param username       the username
     * @param password       the password
     * @param email          the email
     * @param location       the location
     * @param phone          the phone
     */
    public void register(String restaurantName, String username, String password, String email, String location, String phone) {
        RegisterRestaurantRequestModel requestModel = new RegisterRestaurantRequestModel(restaurantName, username, password, email, location, phone);
        this.interactor.registerRestaurant(requestModel);
    }
}
