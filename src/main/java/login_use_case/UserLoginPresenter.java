package login_use_case;

/*
processor of the login use case. Implements the presenter
 */
public class UserLoginPresenter implements UserLoginOutputBoundary {
    private UserLoginScreenInterface loginScreen;

    public UserLoginPresenter(UserLoginScreenInterface loginScreen) {
        this.loginScreen = loginScreen;
    }

    /**
     * when user login success, display the success message, create a home page, and close the login window;
     * @param response response model
     * @return the response model
     */
    @Override
    public UserLoginResponseModel loginSuccess(UserLoginResponseModel response) {
        loginScreen.showMessage("Success");
        loginScreen.showUserHomepage(response.getUserId());
        loginScreen.close();
        return response;
    }

    /**
     * when restaurant login success, display the success message, create a home page, and close the login window;
     * @param response response model
     * @return the response model
     */
    public UserLoginResponseModel loginRestSuccess(UserLoginResponseModel response) {
        loginScreen.showMessage("Success");
        loginScreen.showRestaurantHomepage(response.getUserId(), response.getName());
        loginScreen.close();
        return response;
    }

    /**
     * When login failed. display the failed message
     * @param response response model
     * @return response model
     */
    @Override
    public UserLoginResponseModel loginFailed(UserLoginResponseModel response) {
        loginScreen.showMessage("Login Failed");
        return response;
    }

    /**
     * When login success and the user is not verified, display the message and create a new verify window.
     * @param response response model
     * @return response model
     */
    @Override
    public UserLoginResponseModel userNotVerified(UserLoginResponseModel response) {
        loginScreen.showMessage("You need to verify");
        loginScreen.showVerifyScreen(response.getUserId());
        loginScreen.close();
        return response;
    }

    /**
     * When login success and the restaurant is not verified, display the message and create a new verify window.
     * @param response response model
     * @return response model
     */
    public UserLoginResponseModel restaurantNotVerified(UserLoginResponseModel response) {
        loginScreen.showMessage("You need to verify");
        loginScreen.showRestaurantVerifyScreen(response.getUserId());
        loginScreen.close();
        return response;
    }

    /**
     * set the login screen to the given screen
     * @param loginScreen new login screen
     */
    public void setLoginScreen(UserLoginScreenInterface loginScreen) {
        this.loginScreen = loginScreen;
    }
}
