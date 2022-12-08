package user_verify_use_case;

import database.*;
import org.bson.types.ObjectId;

/**
 * This class is the interactor of get verification code.
 */
public class VerifyUserInteractor {

    private final VerifyUserOutputBoundary presenter;

    /**
     * Constructor of VerifyUserInteractor.
     *
     * @param presenter a verify user presenter
     */
    public VerifyUserInteractor(VerifyUserOutputBoundary presenter) {
        this.presenter = presenter;
    }

    /**
     * Verify user with its id and verification code.
     *
     * @param userId the user id
     * @param code   the verification code
     * @return 1000: Success
     * 1001: Entered Incorrect Code
     * 1002: Expired or code doesn't exist
     */
    public int verifyUser(ObjectId userId, String code) {
        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
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
