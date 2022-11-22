package LoginUseCase;

import LoginUseCase.UserLoginPresenter;
import LoginUseCase.UserLoginResponseModel;
import Screens.LoginScreen;
import Screens.VerifyScreen;
import VerifyuserUseCase.VerifyUserController;
import VerifyuserUseCase.VerifyUserFacade;

import javax.swing.*;
import java.awt.*;

public class UserLoginProcessor implements UserLoginPresenter {
    private JFrame loginScreen;

    public UserLoginProcessor(JFrame loginScreen) {
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
        this.loginScreen.dispose();

        JFrame application = new JFrame("Verify");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        // Build the GUI, plugging in the parts
        VerifyUserFacade facade = new VerifyUserFacade();
        VerifyUserController verifyUserController = new VerifyUserController(facade);

        VerifyScreen verifyScreen = new VerifyScreen(verifyUserController);

        screens.add(verifyScreen.getContentPane(), "verify");
        cardLayout.show(screens, "verify");
        application.pack();
        application.setVisible(true);

        return response;
    }
}
