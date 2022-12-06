package register_user_use_case;

public interface RegisterUserPresenter {
    void registerFailed(String message);
    void registerSuccessful(String message);
    void setScreen(RegisterUserScreenInterface screen);
}
