package user_verify_use_case;

import database.*;
import entities.User;
import entities.VerificationCode;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.Random;

public class GenerateEmailInteractor {
    /**
     * @param userId: the user id of user
     *
     */
    public void generateVerificationEmail(ObjectId userId) {
        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
        VerificationCodeDataGateway dataGateway = new VerificationCodeProcessorMongo(fetcher);
        UserDataGateway userDataGateway = new UserDataProcessorMongo(fetcher);

        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        String verificationCode = String.format("%06d", number);

        String existingCode = GetCodeInteractor.getVerificationCode(userId);

        if (existingCode.isEmpty()) {
            dataGateway.save(userId, new VerificationCode(new Date(), verificationCode));
        } else {
            dataGateway.update(userId, new VerificationCode(new Date(), verificationCode));
        }

        User user = userDataGateway.findById(userId);

        String emailBody = String.format("Your verification code is: %s\nThis code expire in 5 minutes", verificationCode);
        SendEmailInteractor.sendEmail(user.getEmail(), "Verify Your Email", emailBody);
    }

}
