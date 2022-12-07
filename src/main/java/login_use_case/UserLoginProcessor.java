package login_use_case;

public class UserLoginProcessor implements UserLoginPresenter {
    private UserLoginScreenInterface loginScreen;

    public UserLoginProcessor(UserLoginScreenInterface loginScreen) {
        this.loginScreen = loginScreen;
    }

    @Override
    public UserLoginResponseModel loginSuccess(UserLoginResponseModel response) {
        loginScreen.showMessage("Success");
        loginScreen.showUserHomepage(response.getUserId());
        loginScreen.close();
        return response;
    }

    public UserLoginResponseModel loginRestSuccess(UserLoginResponseModel response) {
        loginScreen.showMessage("Success");
        loginScreen.showRestaurantHomepage(response.getUserId(), response.getName());
        loginScreen.close();
        return response;
    }

    @Override
    public UserLoginResponseModel loginFailed(UserLoginResponseModel response) {
        loginScreen.showMessage("Login Failed");
        return response;
    }

    @Override
    public UserLoginResponseModel userNotVerified(UserLoginResponseModel response) {
        loginScreen.showMessage("You need to verify");
        loginScreen.showVerifyScreen(response.getUserId());
        loginScreen.close();
        return response;
    }

    public UserLoginResponseModel restaurantNotVerified(UserLoginResponseModel response) {
        loginScreen.showMessage("You need to verify");
        loginScreen.showRestaurantVerifyScreen(response.getUserId());
        loginScreen.close();
        return response;
    }

    public void setLoginScreen(UserLoginScreenInterface loginScreen) {
        this.loginScreen = loginScreen;
    }
}
