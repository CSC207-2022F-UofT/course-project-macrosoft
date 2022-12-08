package restaurant_register_use_case;

/**
 * This class is the processor for the restaurant register use case.
 */
public class RegisterRestaurantProcessor implements RegisterRestaurantPresenter {

    private RegisterRestaurantScreenInterface screen;

    /**
     * Constructor for RegisterRestaurantProcessor
     *
     * @param screen the screen
     */
    public RegisterRestaurantProcessor(RegisterRestaurantScreenInterface screen) {
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
     * when the registration passes, display a message
     * @param message result message
     */
    @Override
    public void registerSuccessful(String message) {
        screen.showMessage(message);
        screen.showWelcomePage();
        screen.close();
    }

    /**
     * set the screen
     * @param screen new screen
     */
    @Override
    public void setScreen(RegisterRestaurantScreenInterface screen) {
        this.screen = screen;
    }
}
