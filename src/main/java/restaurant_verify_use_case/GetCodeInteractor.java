package restaurant_verify_use_case;

import database.MongoCollectionFetcher;
import database.VerificationCodeDataGateway;
import database.VerificationCodeProcessorMongo;
import entities.VerificationCode;
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
        if (verificationCode == null) return "";
        return verificationCode.getCode();
    }
}

