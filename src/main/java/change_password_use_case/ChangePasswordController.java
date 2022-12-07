package change_password_use_case;

import org.bson.types.ObjectId;

// Interface adapters layer

/**
 * Controller contains current user id and the interactor.
 */
public class ChangePasswordController {
    private final ChangePasswordInputBoundary changePasswordInteractor;
    private final ObjectId currentUserId;

    /**
     * Constructor for ChangePasswordController
     *
     * @param changePasswordInteractor the change password interactor
     * @param currentUserId            the current user id
     */
    public ChangePasswordController(ChangePasswordInputBoundary changePasswordInteractor, ObjectId currentUserId) {
        this.changePasswordInteractor = changePasswordInteractor;
        this.currentUserId = currentUserId;
    }

    /**
     * Change the password of the current user
     *
     * @param originalPassword   the old password
     * @param newPassword        the new password
     * @param confirmNewPassword the confirmed new password
     */
    public void changePassword(String originalPassword, String newPassword, String confirmNewPassword) {
        // Terminate if current user is invalid
        if (this.currentUserId == null) return;

        // Delegate to the interactor
        ChangePasswordRequestModel requestModel = new ChangePasswordRequestModel(this.currentUserId, originalPassword, newPassword, confirmNewPassword);
        changePasswordInteractor.changePassword(requestModel);
    }
}
