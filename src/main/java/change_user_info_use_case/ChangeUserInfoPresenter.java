package change_user_info_use_case;

public interface ChangeUserInfoPresenter {
    void changeUserInfoSuccess(String message);
    void changeUserInfoFailed(String message);
    void setScreen(ChangeUserInfoScreenInterface screen);
}
