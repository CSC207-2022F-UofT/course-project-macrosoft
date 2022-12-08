package login_use_case;
/*
presenter of the login use case
 */
public interface UserLoginOutputBoundary {
    UserLoginResponseModel loginSuccess(UserLoginResponseModel response);
    UserLoginResponseModel loginFailed(UserLoginResponseModel response);
    UserLoginResponseModel userNotVerified(UserLoginResponseModel response);
    UserLoginResponseModel restaurantNotVerified(UserLoginResponseModel response);
    UserLoginResponseModel loginRestSuccess(UserLoginResponseModel response);
    void setLoginScreen(UserLoginScreenInterface loginScreen);
}
