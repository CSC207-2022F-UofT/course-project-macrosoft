package user_profile_use_case;

public class UserProfileProcessor implements UserProfilePresenter {

    private UserProfilePanelInterface userProfilePanel;

    public UserProfileProcessor(UserProfilePanelInterface userProfilePanelInterface) {
        this.userProfilePanel = userProfilePanelInterface;
    }

    /**
     *
     */
    @Override
    public void userFound(UserProfileResponseModel userProfileResponseModel) {
        userProfilePanel.updateNameLabel(userProfileResponseModel.getFirstName() + " " + userProfileResponseModel.getLastName());
        userProfilePanel.updateEmailLabel(userProfileResponseModel.getEmail());
    }

    /**
     *
     */
    @Override
    public void userNotFound() {

    }
}
