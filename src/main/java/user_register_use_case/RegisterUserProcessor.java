package user_register_use_case;

public class RegisterUserProcessor implements RegisterUserPresenter {

    RegisterUserScreenInterface screen;


    public RegisterUserProcessor(RegisterUserScreenInterface screen) {
        this.screen = screen;
    }

    /**
     * when registration failed, display a message
     * @param message result message
     */
    @Override
    public void registerFailed(String message) {
        screen.showMessage(message);
    }

    /**
     * when registration success, show a message, show the welcome page, and close the register window
     * @param message result messsage
     */
    @Override
    public void registerSuccessful(String message) {
        screen.showMessage(message);
        screen.showWelcomePage();
        screen.close();
    }

    /**
     * set the screen to the given screen
     * @param screen new screen
     */
    public void setScreen(RegisterUserScreenInterface screen) {
        this.screen = screen;
    }
}
