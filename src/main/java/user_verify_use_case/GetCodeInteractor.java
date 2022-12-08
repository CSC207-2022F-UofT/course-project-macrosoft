package user_verify_use_case;

import database.MongoCollectionFetcher;
import database.VerificationCodeDataGateway;
import database.VerificationCodeProcessorMongo;
import entities.VerificationCode;
import org.bson.types.ObjectId;

/**
 * This class is the interactor of get verification code.
 */
public class GetCodeInteractor {

    /**
     * Gets verification code.
     *
     * @param userId a user entity
     * @return verification code or nothing
     */
    public static String getVerificationCode(ObjectId userId) {
        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        VerificationCodeDataGateway verificationCodeDataGateway = new VerificationCodeProcessorMongo(fetcher);
        VerificationCode verificationCode = verificationCodeDataGateway.validateAndReadByUser(userId);

        if (verificationCode == null) return "";

        return verificationCode.getCode();
    }
}
