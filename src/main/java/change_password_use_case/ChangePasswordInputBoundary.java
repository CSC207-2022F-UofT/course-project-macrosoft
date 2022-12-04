package change_password_use_case;

import org.bson.types.ObjectId;

public interface ChangePasswordInputBoundary {
    public void changePassword(ChangePasswordRequestModel changePasswordRequestModel);
}
