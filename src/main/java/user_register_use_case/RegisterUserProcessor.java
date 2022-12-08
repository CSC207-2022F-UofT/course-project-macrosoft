package user_register_use_case;

/**
 * This interface is the input boundary of the user register use case.
 */
public class RegisterUserProcessor implements RegisterUserPresenter {

    RegisterUserScreenInterface screen;


    /**
     * Instantiates a new Register user processor.
     *
     * @param screen the screen
     */
    public RegisterUserProcessor(RegisterUserScreenInterface screen) {
        this.screen = screen;
    }

    /**
     * When registration failed, display a message
     *
     * @param message result message
     */
    @Override
    public void registerFailed(String message) {
        screen.showMessage(message);
    }

    /**
     * When registration success, show a message, show the welcome page, and close the register window
     *
     * @param message result messsage
     */
    @Override
    public void registerSuccessful(String message) {
        screen.showMessage(message);
        screen.showWelcomePage();
        screen.close();
    }

    /**
     * Sets the screen to the given screen
     *
     * @param screen new screen
     */
    public void setScreen(RegisterUserScreenInterface screen) {
        this.screen = screen;
    }
}
