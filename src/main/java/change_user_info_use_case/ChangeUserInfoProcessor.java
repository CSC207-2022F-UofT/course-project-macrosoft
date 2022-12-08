package change_user_info_use_case;

public class ChangeUserInfoProcessor implements ChangeUserInfoPresenter {

    ChangeUserInfoScreenInterface screen;


    public ChangeUserInfoProcessor(ChangeUserInfoScreenInterface screen) {
        this.screen = screen;
    }

    /**
     * @param message result message
     */
    @Override
    public void changeUserInfoSuccess(String message) {
        this.screen.showMessage(message);
        this.screen.close();
    }

    /**
     * @param message result message
     */
    @Override
    public void changeUserInfoFailed(String message) {
        this.screen.showMessage(message);
    }

    public ChangeUserInfoScreenInterface getScreen() {
        return screen;
    }

    public void setScreen(ChangeUserInfoScreenInterface screen) {
        this.screen = screen;
    }
}
