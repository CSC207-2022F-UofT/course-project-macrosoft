package change_user_info_use_case;
/*
Presenter of the change user information use case
 */
public interface ChangeUserInfoOutputBoundary {
    void changeUserInfoSuccess(String message);
    void changeUserInfoFailed(String message);
    void setScreen(ChangeUserInfoScreenInterface screen);
}
