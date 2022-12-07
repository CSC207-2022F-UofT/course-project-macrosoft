package change_password_use_case;

import org.bson.types.ObjectId;

// Use case layer

/**
 * This class is the request model for the change password use case.
 */
public class ChangePasswordRequestModel {
    private final ObjectId currentUserId;
    private final String oldPassword;
    private final String newPassword;
    private final String confirmNewPassword;

    /**
     * Constructor for ChangePasswordRequestModel
     *
     * @param currentUserId      the current user id
     * @param oldPassword        the old password
     * @param newPassword        the new password
     * @param confirmNewPassword the confirmed new password
     */
    public ChangePasswordRequestModel(ObjectId currentUserId, String oldPassword, String newPassword, String confirmNewPassword) {
        this.currentUserId = currentUserId;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.confirmNewPassword = confirmNewPassword;
    }

    /**
     * Get the current user id
     *
     * @return the current user id
     */
    public ObjectId getCurrentUserId() {
        return currentUserId;
    }

    /**
     * Get the old password
     *
     * @return the old password
     */
    public String getOldPassword() {
        return oldPassword;
    }

    /**
     * Get the new password
     *
     * @return the new password
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * Get the confirmed new password
     *
     * @return the confirmed new password
     */
    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }
}
