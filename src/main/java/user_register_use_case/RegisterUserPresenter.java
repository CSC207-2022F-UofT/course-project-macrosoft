package user_register_use_case;

/**
 * presenter of the use case
 */
public interface RegisterUserPresenter {
    /**
     * Failed to register a user.
     *
     * @param message the message
     */
    void registerFailed(String message);

    /**
     * Register successful.
     *
     * @param message the message
     */
    void registerSuccessful(String message);

    /**
     * Sets screen.
     *
     * @param screen the screen
     */
    void setScreen(RegisterUserScreenInterface screen);
}
