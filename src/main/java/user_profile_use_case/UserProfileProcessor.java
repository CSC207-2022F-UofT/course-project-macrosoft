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

    }

    /**
     *
     */
    @Override
    public void userNotFound() {

    }
}
