package change_password_use_case;

// Use case layer

public interface ChangePasswordPresenter {
    public void changePasswordSuccess(ChangePasswordResponseModel responseModel);
    public void changePasswordFailed(ChangePasswordResponseModel responseModel);
    public void setChangePasswordScreenInterface(ChangePasswordScreenInterface changePasswordScreenInterface);
}
