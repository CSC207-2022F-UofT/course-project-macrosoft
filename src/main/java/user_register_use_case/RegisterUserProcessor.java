package user_register_use_case;

public class RegisterUserProcessor implements RegisterUserPresenter {

    RegisterUserScreenInterface screen;

    public RegisterUserProcessor(RegisterUserScreenInterface screen) {
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

    public void setScreen(RegisterUserScreenInterface screen) {
        this.screen = screen;
    }
}
