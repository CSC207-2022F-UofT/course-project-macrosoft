package change_password_use_case;

// Use case layer

/**
 * This class is the presenter interface for the change password use case.
 * The ChangePasswordProcessor implements this interface
 */
public interface ChangePasswordPresenter {

    /**
     * Success view.
     * @param responseModel response model
     */
    void changePasswordSuccess(ChangePasswordResponseModel responseModel);

    /**
     * failed view
     * @param responseModel request model
     */

    void changePasswordFailed(ChangePasswordResponseModel responseModel);

    void setChangePasswordScreenInterface(ChangePasswordScreenInterface changePasswordScreenInterface);
}
