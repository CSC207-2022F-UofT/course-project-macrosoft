package restaurant_verify_use_case;

import database.*;
import org.bson.types.ObjectId;

/**
 * This class is the interactor for the restaurant verify use case.
 */
public class VerifyResInteractor {
    private VerifyResPresenter presenter;

    /**
     * Constructor for VerifyResInteractor.
     *
     * @param presenter the presenter
     */
    public VerifyResInteractor(VerifyResPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Verifies restaurant by its id and code.
     *
     * @param restaurantId the restaurant id
     * @param code         the code
     * @return 1000: Success
     * 1001: Entered Incorrect Code
     * 1002: Expired or code doesn't exist
     */
    public int verifyRes(ObjectId restaurantId, String code) {
        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        VerificationCodeDataGateway verificationCodeDataGateway = new VerificationCodeProcessorMongo(fetcher);
        RestaurantDataGateway restaurantDataGateway = new RestaurantDataMongo(fetcher);

        String actualCode = GetCodeInteractor.getVerificationCode(restaurantId);

        if (actualCode.isEmpty()) {
            presenter.verifiedFailed();
            return 1002;
        } else if (!code.equals(actualCode)) {
            presenter.verifiedFailed();
            return 1001;
        }

        verificationCodeDataGateway.deleteByUserId(restaurantId);
        restaurantDataGateway.updateVerifiedStatus(restaurantId, true);

        String name = restaurantDataGateway.getRestaurantNameById(restaurantId);

        presenter.verifiedSuccess(restaurantId, name);
        return 1000;
    }
}