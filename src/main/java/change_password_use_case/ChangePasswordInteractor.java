package change_password_use_case;

import database.AuthInfoDataGateway;
import database.AuthInfoProcessorMongo;
import database.MongoCollectionFetcher;
import entities.AuthInfo;
import library.PasswordHasher;
import org.bson.types.ObjectId;

import java.security.NoSuchAlgorithmException;

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
        MongoCollectionFetcher mongoCollectionFetcher = new MongoCollectionFetcher();
        AuthInfoDataGateway authInfoDataGateway = new AuthInfoProcessorMongo(mongoCollectionFetcher);

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


        AuthInfo authInfo = authInfoDataGateway.getUserByUserIdPassword(
                changePasswordRequestModel.getCurrentUserId(),
                hashedOriginalPassword);

        if (authInfo == null) {
            ChangePasswordResponseModel responseModel = new ChangePasswordResponseModel("Invalid original password");
            presenter.changePasswordFailed(responseModel);
        }
        else if (!changePasswordRequestModel.getNewPassword().equals(changePasswordRequestModel.getConfirmNewPassword())) {
            ChangePasswordResponseModel responseModel = new ChangePasswordResponseModel("New password does not match");
            presenter.changePasswordFailed(responseModel);
        } else {
            authInfoDataGateway.setNewPassword(changePasswordRequestModel.getCurrentUserId(), hashedNewPassword);

            ChangePasswordResponseModel responseModel = new ChangePasswordResponseModel("Password change success");
            presenter.changePasswordSuccess(responseModel);
        }
    }
}
