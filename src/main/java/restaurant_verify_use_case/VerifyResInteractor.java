package restaurant_verify_use_case;

import database.*;
import org.bson.types.ObjectId;

public class VerifyResInteractor {
    private VerifyResPresenter presenter;


    public VerifyResInteractor(VerifyResPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * @param restaurantId
     * @param code
     * @return 1000: Success
     * 1001: Entered Incorrect Code
     * 1002: Expired or code doesn't exist
     */
    public int verifyRes(ObjectId restaurantId, String code) {
        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
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