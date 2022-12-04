package change_password_use_case;

import org.bson.types.ObjectId;

public class ChangePasswordRequestModel {
    private ObjectId currentUserId;
    private String oldPassword;
    private String newPassword;
    private String confirmNewPassword;

    public ChangePasswordRequestModel(ObjectId currentUserId, String oldPassword, String newPassword, String confirmNewPassword) {
        this.currentUserId = currentUserId;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.confirmNewPassword = confirmNewPassword;
    }

    public ObjectId getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(ObjectId currentUserId) {
        this.currentUserId = currentUserId;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }
}
