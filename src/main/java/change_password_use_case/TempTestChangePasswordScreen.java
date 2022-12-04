package change_password_use_case;

import org.bson.types.ObjectId;

public class TempTestChangePasswordScreen {
    public static void main(String[] args) {
        ChangePasswordPresenter changePasswordPresenter = new ChangePasswordProcessor(null);
        ChangePasswordInputBoundary changePasswordInputBoundary = new ChangePasswordInteractor(changePasswordPresenter);
        ChangePasswordController changePasswordController = new ChangePasswordController(changePasswordInputBoundary, new ObjectId("63504de50fd7682673870fde"));

        ChangePasswordScreenInterface changePasswordScreen = new ChangePasswordScreen(changePasswordController);

        changePasswordPresenter.setChangePasswordScreenInterface(changePasswordScreen);

        changePasswordScreen.getFrame().setVisible(true);
    }
}
