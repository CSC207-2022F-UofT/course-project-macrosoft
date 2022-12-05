package change_password_use_case;

import org.bson.types.ObjectId;

// Interface adapters layer

public class ChangePasswordController {
    private ChangePasswordInputBoundary changePasswordInteractor;
    private ObjectId currentUserId;


    public ChangePasswordController(ChangePasswordInputBoundary changePasswordInteractor, ObjectId currentUserId) {
        this.changePasswordInteractor = changePasswordInteractor;
        this.currentUserId = currentUserId;
    }

    public void changePassword(String originalPassword, String newPassword, String confirmNewPassword) {
        // Terminate if current user is invalid
        if (this.currentUserId == null) return;

        // Delegate to the interactor
        ChangePasswordRequestModel requestModel = new ChangePasswordRequestModel(this.currentUserId, originalPassword, newPassword, confirmNewPassword);
        changePasswordInteractor.changePassword(requestModel);
    }
}
