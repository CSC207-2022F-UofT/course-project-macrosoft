package restaurant_profile_use_case;
/*
screen interface of the restaurnat profile use case.
 */
public interface RestaurantProfilePanelInterface {
    void updateNameLabel(String newName);
    void updateEmailLabel(String newEmail);
    void updateLocationLabel(String newLocation);
    void updatePhoneLabel(String newPhone);
    void updatePanelData();
}
