package change_password_use_case;

// Use case layer

/**
 * This interface is the presenter interface for the change password use case.
 * The ChangePasswordPresenter implements this interface
 */
public interface ChangePasswordOutputBoundary {

    /**
     * Success view.
     *
     * @param responseModel response model
     */
    void changePasswordSuccess(ChangePasswordResponseModel responseModel);

    /**
     * failed view
     *
     * @param responseModel request model
     */
    void changePasswordFailed(ChangePasswordResponseModel responseModel);

    /**
     * Sets the change password screen interface
     *
     * @param changePasswordScreenInterface the change password screen interface
     */
    void setChangePasswordScreenInterface(ChangePasswordScreenInterface changePasswordScreenInterface);
}
