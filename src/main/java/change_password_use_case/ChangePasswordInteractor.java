package change_password_use_case;

import database.AuthInfoDataGateway;
import database.AuthInfoProcessorMongo;
import database.MongoCollectionFetcher;
import entities.AuthInfo;
import library.PasswordHasher;

import java.security.NoSuchAlgorithmException;

// Use case layer

public class ChangePasswordInteractor implements ChangePasswordInputBoundary {

    private ChangePasswordPresenter presenter;

    public ChangePasswordInteractor(ChangePasswordPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * @param changePasswordRequestModel
     */
    @Override
    public void changePassword(ChangePasswordRequestModel changePasswordRequestModel) {
        // Initialize the database access gateway
        MongoCollectionFetcher mongoCollectionFetcher = MongoCollectionFetcher.getFetcher();
        AuthInfoDataGateway authInfoDataGateway = new AuthInfoProcessorMongo(mongoCollectionFetcher);

        // Hash the password before the query so they match the password stored in the database
        String hashedOriginalPassword;
        String hashedNewPassword;
        try {
            hashedOriginalPassword = PasswordHasher.toHexString(
                    PasswordHasher.getSHA(changePasswordRequestModel.getOldPassword()));
            hashedNewPassword = PasswordHasher.toHexString(
                    PasswordHasher.getSHA(changePasswordRequestModel.getNewPassword()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // See if the user has entered the correct original password
        AuthInfo authInfo = authInfoDataGateway.getUserByUserIdPassword(
                changePasswordRequestModel.getCurrentUserId(),
                hashedOriginalPassword);

        // Display failed message if the user has entered the wrong original password
        if (authInfo == null) {
            ChangePasswordResponseModel responseModel = new ChangePasswordResponseModel("Invalid original password");

            presenter.changePasswordFailed(responseModel);
        }
        // Display failed message if the new password and confirmation doesn't match
        else if (!changePasswordRequestModel.getNewPassword().equals(changePasswordRequestModel.getConfirmNewPassword())) {
            ChangePasswordResponseModel responseModel = new ChangePasswordResponseModel("New password does not match");

            presenter.changePasswordFailed(responseModel);
        }
        // Change the password and display prompt if success
        else {
            authInfoDataGateway.setNewPassword(changePasswordRequestModel.getCurrentUserId(), hashedNewPassword);

            ChangePasswordResponseModel responseModel = new ChangePasswordResponseModel("Password change success");

            presenter.changePasswordSuccess(responseModel);
        }
    }
}
