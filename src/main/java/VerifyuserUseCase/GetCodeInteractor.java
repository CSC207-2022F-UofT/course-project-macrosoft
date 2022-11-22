package VerifyuserUseCase;

import Database.VerificationCodeDataGateway;
import Database.VerificationCodeProcessorMongo;
import Entities.User;
import Entities.VerificationCode;
import Interactors.DBConnection;
import Interactors.MongoConnection;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.Date;

public class GetCodeInteractor {

    /**
     *
     * @param userId: a user entity
     * @return: return verification code or nothing
     */
    public static String getVerificationCode(ObjectId userId) {
        VerificationCodeDataGateway verificationCodeDataGateway = new VerificationCodeProcessorMongo();
        VerificationCode verificationCode = verificationCodeDataGateway.validateAndReadByUser(userId);
        return verificationCode.getCode();
    }
}
