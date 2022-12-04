package change_password_use_case;

public class ChangePasswordProcessor implements ChangePasswordPresenter {

    private ChangePasswordScreenInterface changePasswordScreenInterface;

    public ChangePasswordProcessor(ChangePasswordScreenInterface changePasswordScreenInterface) {
        this.changePasswordScreenInterface = changePasswordScreenInterface;
    }

    /**
     *
     */
    @Override
    public void changePasswordSuccess(ChangePasswordResponseModel responseModel) {
        this.changePasswordScreenInterface.showMessage(responseModel.getMessage());
        this.changePasswordScreenInterface.close();
    }

    /**
     *
     */
    @Override
    public void changePasswordFailed(ChangePasswordResponseModel responseModel) {
        this.changePasswordScreenInterface.showMessage(responseModel.getMessage());
    }

    @Override
    public void setChangePasswordScreenInterface(ChangePasswordScreenInterface changePasswordScreenInterface) {
        this.changePasswordScreenInterface = changePasswordScreenInterface;
    }
}
