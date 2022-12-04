package login_use_case;

public class TempTestUserLoginScreen {
    public static void main(String[] args) {
        UserLoginPresenter userLoginPresenter = new UserLoginProcessor(null);
        UserLoginInputBoundary userLoginInteractor = new UserLoginInteractor(userLoginPresenter);
        UserLoginController userLoginController = new UserLoginController(userLoginInteractor);
        UserLoginScreenInterface screen = new UserLoginScreen(userLoginController);

        userLoginPresenter.setLoginScreen(screen);

        screen.getFrame().setVisible(true);
    }
}
