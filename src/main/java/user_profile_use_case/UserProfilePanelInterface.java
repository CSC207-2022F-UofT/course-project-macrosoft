package user_profile_use_case;

public interface UserProfilePanelInterface {
    public void updateNameLabel(String newName);
    public void updateEmailLabel(String newEmail);
    public void updatePanelData();
    public void showChangePasswordScreen();
}
