package user_profile_use_case;

/**
 * presenter of the use_case
 */
public interface UserProfileOutputBoundary {
    /**
     * User found.
     *
     * @param userProfileResponseModel the response model
     */
    void userFound(UserProfileResponseModel userProfileResponseModel);

    /**
     * User not found.
     */
    void userNotFound();

    /**
     * Sets user profile panel.
     *
     * @param userProfilePanel the user profile panel
     */
    void setUserProfilePanel(UserProfilePanelInterface userProfilePanel);
}
