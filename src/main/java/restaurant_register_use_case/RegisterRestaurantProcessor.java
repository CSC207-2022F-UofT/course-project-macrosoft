package restaurant_register_use_case;

public class RegisterRestaurantProcessor implements RegisterRestaurantPresenter {

    private RegisterRestaurantScreenInterface screen;

    public RegisterRestaurantProcessor(RegisterRestaurantScreenInterface screen) {
        this.screen = screen;
    }

    @Override
    public void registerFailed(String message) {
        screen.showMessage(message);
    }

    @Override
    public void registerSuccessful(String message) {
        screen.showMessage(message);
        screen.showWelcomePage();
        screen.close();
    }

    @Override
    public void setScreen(RegisterRestaurantScreenInterface screen) {
        this.screen = screen;
    }
}
