package change_password_use_case;

// Use case layer

/**
 * This class is the presenter for the change password use case.
 */
public interface ChangePasswordPresenter {
    public void changePasswordSuccess(ChangePasswordResponseModel responseModel);

    public void changePasswordFailed(ChangePasswordResponseModel responseModel);

    public void setChangePasswordScreenInterface(ChangePasswordScreenInterface changePasswordScreenInterface);
}
