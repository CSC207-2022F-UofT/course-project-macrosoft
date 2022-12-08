package login_use_case;

/**
 * This interface is the login input boundary for the restaurant login use case.
 */
public interface RestaurantLoginInputBoundary {
    /**
     * Login the restaurant
     *
     * @param requestModel the request model
     */
    UserLoginResponseModel login(RestaurantLoginRequestModel requestModel);
}
