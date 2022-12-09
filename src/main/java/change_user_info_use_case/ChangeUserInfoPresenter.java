package change_user_info_use_case;

/**
 * Presenter of the change user information use case
 */
public class ChangeUserInfoPresenter implements ChangeUserInfoOutputBoundary {

    ChangeUserInfoScreenInterface screen;


    /**
     * Constructor of the change user information presenter
     *
     * @param screen the change user information screen interface
     */
    public ChangeUserInfoPresenter(ChangeUserInfoScreenInterface screen) {
        this.screen = screen;
    }

    /**
     * success
     *
     * @param message success message
     */
    @Override
    public void changeUserInfoSuccess(String message) {
        this.screen.showMessage(message);
        this.screen.close();
    }

    /**
     * failed
     *
     * @param message failed message
     */
    @Override
    public void changeUserInfoFailed(String message) {
        this.screen.showMessage(message);
    }

    /**
     * Gets the screen.
     *
     * @return the screen
     */
    public ChangeUserInfoScreenInterface getScreen() {
        return screen;
    }

    /**
     * Sets the screen.
     *
     * @param screen the new screen
     */
    public void setScreen(ChangeUserInfoScreenInterface screen) {
        this.screen = screen;
    }
}
