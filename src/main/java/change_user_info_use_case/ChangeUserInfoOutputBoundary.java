package change_user_info_use_case;

/**
 * Presenter of the change user information use case
 */
public interface ChangeUserInfoOutputBoundary {
    /**
     * success
     *
     * @param message success message
     */
    void changeUserInfoSuccess(String message);

    /**
     * failed
     *
     * @param message failed message
     */
    void changeUserInfoFailed(String message);

    /**
     * set the change user information screen interface
     *
     * @param screen the change user information screen interface
     */
    void setScreen(ChangeUserInfoScreenInterface screen);
}
