package change_password_use_case;

import Database.AuthInfoDataGateway;
import Database.AuthInfoProcessorMongo;
import Database.MongoCollectionFetcher;
import Entities.AuthInfo;
import org.bson.types.ObjectId;

public class ChangePasswordInteractor implements ChangePasswordInputBoundary {

    private ChangePasswordPresenter presenter;

    public ChangePasswordInteractor(ChangePasswordPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * @param oldPassword
     * @param newPassword
     */
    @Override
    public void changePassword(ObjectId userId, String oldPassword, String newPassword) {
        MongoCollectionFetcher mongoCollectionFetcher = new MongoCollectionFetcher();
        AuthInfoDataGateway authInfoDataGateway = new AuthInfoProcessorMongo(mongoCollectionFetcher);

        AuthInfo authInfo = authInfoDataGateway.getUserByUserIdPassword(userId, oldPassword);

        if (authInfo == null) presenter.changePasswordFailed();
        else {

            presenter.changePasswordSuccess();
        }
    }
}
