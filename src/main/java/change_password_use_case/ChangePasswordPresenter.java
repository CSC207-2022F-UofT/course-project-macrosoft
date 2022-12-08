package change_password_use_case;

// Use case layer

/**
 * This class is the presenter for the change password use case.
 */
public interface ChangePasswordPresenter {
    void changePasswordSuccess(ChangePasswordResponseModel responseModel);

    void changePasswordFailed(ChangePasswordResponseModel responseModel);

    void setChangePasswordScreenInterface(ChangePasswordScreenInterface changePasswordScreenInterface);
}
