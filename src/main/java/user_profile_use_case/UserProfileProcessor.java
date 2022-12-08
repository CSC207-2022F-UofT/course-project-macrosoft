package user_profile_use_case;

/**
 * This class is the processor of the user profile.
 */
public class UserProfileProcessor implements UserProfilePresenter {

    private UserProfilePanelInterface userProfilePanel;

    /**
     * Constructor for UserProfileProcessor
     *
     * @param userProfilePanelInterface the user profile panel
     */
    public UserProfileProcessor(UserProfilePanelInterface userProfilePanelInterface) {
        this.userProfilePanel = userProfilePanelInterface;
    }


    /**
     * When the user is found, update the name and information according to the response model
     *
     * @param userProfileResponseModel response model
     */
    @Override
    public void userFound(UserProfileResponseModel userProfileResponseModel) {
        userProfilePanel.updateNameLabel(userProfileResponseModel.getFirstName() + " " + userProfileResponseModel.getLastName());
        userProfilePanel.updateEmailLabel(userProfileResponseModel.getEmail());
    }


    /**
     * when the user is not found
     */
    @Override
    public void userNotFound() {

    }

    /**
     * set the panel to the given panel
     *
     * @param userProfilePanel panel
     */
    public void setUserProfilePanel(UserProfilePanelInterface userProfilePanel) {
        this.userProfilePanel = userProfilePanel;
    }
}
