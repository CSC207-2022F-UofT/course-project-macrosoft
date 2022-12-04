package user_profile_use_case;

public interface UserProfilePresenter {
    void userFound(UserProfileResponseModel userProfileResponseModel);
    void userNotFound();
    void setUserProfilePanel(UserProfilePanelInterface userProfilePanel);
}
