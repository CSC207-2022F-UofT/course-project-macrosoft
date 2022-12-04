package login_use_case;

public interface UserLoginPresenter {
    UserLoginResponseModel loginSuccess(UserLoginResponseModel response);
    UserLoginResponseModel loginFailed(UserLoginResponseModel response);
    UserLoginResponseModel notVerified(UserLoginResponseModel response);
    void setLoginScreen(UserLoginScreenInterface loginScreen);
}
