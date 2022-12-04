package change_password_use_case;

import org.bson.types.ObjectId;

public class ChangePasswordController {
    private ChangePasswordInputBoundary changePasswordInteractor;
    private ObjectId currentUserId;

    public ChangePasswordController(ChangePasswordInputBoundary changePasswordInteractor, ObjectId currentUserId) {
        this.changePasswordInteractor = changePasswordInteractor;
        this.currentUserId = currentUserId;
    }

    public void changePassword(String originalPassword, String newPassword, String confirmNewPassword) {
        if (this.currentUserId == null) return;

        ChangePasswordRequestModel requestModel = new ChangePasswordRequestModel(this.currentUserId, originalPassword, newPassword, confirmNewPassword);
        changePasswordInteractor.changePassword(requestModel);
    }
}
