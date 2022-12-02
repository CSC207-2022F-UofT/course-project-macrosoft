package VerifyrestaurantUseCase;

import Database.MongoCollectionFetcher;
import Database.VerificationCodeDataGateway;
import Database.VerificationCodeProcessorMongo;
import Entities.VerificationCode;
import org.bson.types.ObjectId;

public class GetCodeInteractor {

    /**
     *
     * @return restaurantID return verification code or nothing
     */
    public static String getVerificationCode(ObjectId restaurantID) {
        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
        VerificationCodeDataGateway verificationCodeDataGateway = new VerificationCodeProcessorMongo(fetcher);
        VerificationCode verificationCode = verificationCodeDataGateway.validateAndReadByUser(restaurantID);
        return verificationCode.getCode();
    }
}

