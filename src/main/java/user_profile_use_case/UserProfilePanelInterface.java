package user_profile_use_case;

import org.bson.types.ObjectId;

public interface UserProfilePanelInterface {
    public void updateNameLabel(String newName);
    public void updateEmailLabel(String newEmail);
    public void updatePanelData();
}
