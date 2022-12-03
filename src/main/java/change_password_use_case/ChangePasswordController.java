package change_password_use_case;

public class ChangePasswordController {
    private ChangePasswordInputBoundary changePasswordInteractor;

    public ChangePasswordController(ChangePasswordInputBoundary changePasswordInteractor) {
        this.changePasswordInteractor = changePasswordInteractor;
    }
}
