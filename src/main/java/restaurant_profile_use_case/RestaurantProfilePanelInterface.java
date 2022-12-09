package restaurant_profile_use_case;

/**
 * screen interface of the restaurnat profile use case.
 */
public interface RestaurantProfilePanelInterface {
    /**
     * Updates the name label.
     *
     * @param newName the new name
     */
    void updateNameLabel(String newName);

    /**
     * Updates the email label.
     *
     * @param newEmail the new email
     */
    void updateEmailLabel(String newEmail);

    /**
     * Updates the location label.
     *
     * @param newLocation the new location
     */
    void updateLocationLabel(String newLocation);

    /**
     * Updates the phone label.
     *
     * @param newPhone the new phone
     */
    void updatePhoneLabel(String newPhone);

    /**
     * Updates the panel data.
     */
    void updatePanelData();
}
