package welcome_use_case;

import components.ScreenFactory;

/**
 * This class is the controller of welcome use case.
 */
public class WelcomeScreenController {

    /**
     * Gets login screen.
     */
    public void getLoginScreen() {
        ScreenFactory screenFactory = new ScreenFactory();
        screenFactory.createLoginSreen();
    }

    /**
     * Gets register restaurant screen.
     */
    public void getRegisterRestaurantScreen() {
        ScreenFactory screenFactory = new ScreenFactory();
        screenFactory.createRestaurantRegisterScreen();
    }

    /**
     * Gets register user screen.
     */
    public void getRegisterUserScreen() {
        ScreenFactory screenFactory = new ScreenFactory();
        screenFactory.createUserRegisterScreen();
    }
}
