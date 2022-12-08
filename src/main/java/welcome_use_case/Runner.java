package welcome_use_case;

import components.ScreenFactory;

public class Runner {
    public static void main(String[] args) {
        ScreenFactory screenFactory = new ScreenFactory();
        screenFactory.createWelcomeScreen();
    }
}
