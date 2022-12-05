package login_use_case;

import verify_user_use_case.VerifyUserScreen;
import verify_user_use_case.VerifyUserController;
import verify_user_use_case.VerifyUserFacade;

import javax.swing.*;
import java.awt.*;

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

    @Override
    public UserLoginResponseModel loginFailed(UserLoginResponseModel response) {
        loginScreen.showMessage("Failed");
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
