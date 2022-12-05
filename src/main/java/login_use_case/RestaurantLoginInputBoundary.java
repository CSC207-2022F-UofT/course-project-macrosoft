package login_use_case;

public interface RestaurantLoginInputBoundary {
    UserLoginResponseModel login(RestaurantLoginRequestModel requestModel);
}
