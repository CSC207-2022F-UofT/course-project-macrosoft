package user_register_use_case;

/*
presenter of the use case
 */
public interface RegisterUserPresenter {
    void registerFailed(String message);
    void registerSuccessful(String message);
    void setScreen(RegisterUserScreenInterface screen);
}
