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
        return response;
    }

    @Override
    public UserLoginResponseModel loginFailed(UserLoginResponseModel response) {
        return response;
    }

    @Override
    public UserLoginResponseModel notVerified(UserLoginResponseModel response) {
        loginScreen.showVerifiedScreen();
        loginScreen.close();
        return response;
    }

    public void setLoginScreen(UserLoginScreenInterface loginScreen) {
        this.loginScreen = loginScreen;
    }
}
