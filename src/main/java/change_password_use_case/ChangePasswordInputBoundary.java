package change_password_use_case;

// Use case layer

/**
 * This interface is the input boundary for the change password use case.
 */
public interface ChangePasswordInputBoundary {
    /**
     * This method is the input boundary for the change password use case.
     *
     * @param changePasswordRequestModel the request model
     */
    void changePassword(ChangePasswordRequestModel changePasswordRequestModel);
}
