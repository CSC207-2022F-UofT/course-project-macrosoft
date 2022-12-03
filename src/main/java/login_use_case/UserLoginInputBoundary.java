package login_use_case;

public interface UserLoginInputBoundary {
    public UserLoginResponseModel login(UserLoginRequestModel requestModel);
}
