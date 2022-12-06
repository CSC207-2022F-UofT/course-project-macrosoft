package user_verify_use_case;

import database.MongoCollectionFetcher;
import database.VerificationCodeDataGateway;
import database.VerificationCodeProcessorMongo;
import entities.VerificationCode;
import org.bson.types.ObjectId;

public class GetCodeInteractor {

    /**
     *
     * @param userId: a user entity
     * @return: return verification code or nothing
     */
    public static String getVerificationCode(ObjectId userId) {
        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
        VerificationCodeDataGateway verificationCodeDataGateway = new VerificationCodeProcessorMongo(fetcher);
        VerificationCode verificationCode = verificationCodeDataGateway.validateAndReadByUser(userId);

        if (verificationCode == null) return "";

        return verificationCode.getCode();
    }
}
