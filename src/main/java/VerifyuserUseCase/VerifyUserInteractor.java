package VerifyuserUseCase;

import Database.*;
import Entities.User;
import Interactors.DBConnection;
import Interactors.MongoConnection;
import LoginUseCase.UserLoginPresenter;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class VerifyUserInteractor {

    private VerifyUserPresenter presenter;
    /**
     * @param userId
     * @param code
     * @return 1000: Success
     * 1001: Entered Incorrect Code
     * 1002: Expired or code doesn't exist
     */
    public int verifyUser(ObjectId userId, String code) {
        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
        VerificationCodeDataGateway verificationCodeDataGateway = new VerificationCodeProcessorMongo(fetcher);
        UserDataGateway userDataGateway = new UserDataProcessorMongo(fetcher);

        String actualCode = GetCodeInteractor.getVerificationCode(userId);

        if (actualCode.isEmpty()) {
            presenter.verifiedFailed();
            return 1002;
        } else if (!code.equals(actualCode)) {
            presenter.verifiedFailed();
            return 1001;
        }

        verificationCodeDataGateway.deleteByUserId(userId);
        userDataGateway.updateVerifiedStatus(userId, true);

        presenter.verifiedSuccess(userId);
        return 1000;
    }
}
