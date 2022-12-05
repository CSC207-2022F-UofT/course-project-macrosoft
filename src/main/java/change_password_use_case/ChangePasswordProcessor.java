package change_password_use_case;

// Interface adapters layer

public class ChangePasswordProcessor implements ChangePasswordPresenter {

    private ChangePasswordScreenInterface changePasswordScreenInterface;

    public ChangePasswordProcessor(ChangePasswordScreenInterface changePasswordScreenInterface) {
        this.changePasswordScreenInterface = changePasswordScreenInterface;
    }

    /**
     * Handles the case when change password is successful
     * @param responseModel the response model from interactor
     */
    @Override
    public void changePasswordSuccess(ChangePasswordResponseModel responseModel) {
        // Display the message from the response model
        this.changePasswordScreenInterface.showMessage(responseModel.getMessage());
        // Close the frame
        this.changePasswordScreenInterface.close();
    }

    /**
     * Handles the case when change password failed
     * @param responseModel the response model from interactor
     */
    @Override
    public void changePasswordFailed(ChangePasswordResponseModel responseModel) {
        // Display the message from the response model but keep the frame open
        this.changePasswordScreenInterface.showMessage(responseModel.getMessage());
    }

    @Override
    public void setChangePasswordScreenInterface(ChangePasswordScreenInterface changePasswordScreenInterface) {
        this.changePasswordScreenInterface = changePasswordScreenInterface;
    }
}
