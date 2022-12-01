package VerifyuserUseCase;

import Entities.User;
import Interactors.DBConnection;
import Interactors.MongoConnection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.Random;

public class GenerateEmailInteractor {
    private static DBConnection connectionManager = new MongoConnection();

    /**
     * @param userId: the user id of user
     * @param email: the email of user
     *
     */
    public void generateVerificationEmail(ObjectId userId, String email) {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        String verificationCode = String.format("%06d", number);

        String existingCode = GetCodeInteractor.getVerificationCode(userId);

        if (existingCode.isEmpty()) {
            Document verificationCodeDoc = new Document("userID", userId)
                    .append("code", verificationCode)
                    .append("createdTime", new Date());

            connectionManager.getCollection("Verification").insertOne(verificationCodeDoc);
        } else {
            Bson filter = Filters.eq("userID", userId);
            Bson update = Updates.combine(Updates.set("code", verificationCode), Updates.set("createdTime", new Date()));

            connectionManager.getCollection("Verification").updateOne(filter, update);
        }

        String emailBody = String.format("Your verification code is: %s\nThis code expire in 5 minutes", verificationCode);
        SendEmailInteractor.sendEmail(email, "Verify Your Email", emailBody);
    }

}
