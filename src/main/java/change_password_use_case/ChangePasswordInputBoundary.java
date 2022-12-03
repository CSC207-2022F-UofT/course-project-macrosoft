package change_password_use_case;

import org.bson.types.ObjectId;

public interface ChangePasswordInputBoundary {
    public void changePassword(ObjectId userId, String oldPassword, String newPassword);
}
