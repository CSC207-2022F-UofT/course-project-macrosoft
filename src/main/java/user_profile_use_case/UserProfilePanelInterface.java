package user_profile_use_case;

/**
 * interface of the screen
 */
public interface UserProfilePanelInterface {
    /**
     * Updates the name label
     *
     * @param newName the new name
     */
    void updateNameLabel(String newName);

    /**
     * Updates the email label
     *
     * @param newEmail the new email
     */
    void updateEmailLabel(String newEmail);

    /**
     * Updates the panel data
     */
    void updatePanelData();
}
