package welcome_use_case;

import components.ScreenFactory;

public class WelcomeScreenController {

    public void getLoginScreen(){
        ScreenFactory screenFactory = new ScreenFactory();
        screenFactory.createLoginSreen();
    }

    public void getRegisterRestaurantScreen(){
        ScreenFactory screenFactory = new ScreenFactory();
        screenFactory.createRestaurantRegisterScreen();
    }

    public void getRegisterUserScreen(){
        ScreenFactory screenFactory = new ScreenFactory();
        screenFactory.createUserRegisterScreen();
    }
}
