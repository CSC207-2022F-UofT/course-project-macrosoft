package verify_restaurant_use_case;

import interactors.DBConnection;
import interactors.MongoConnection;
import verify_user_use_case.GetCodeInteractor;
import verify_user_use_case.SendEmailInteractor;
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
     * @param restaurantID: the restaurant id
     * @param email: the email of restaurant
     *
     */
    public void generateVerificationEmail(ObjectId restaurantID, String email) {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        String verificationCode = String.format("%06d", number);

        String existingCode = GetCodeInteractor.getVerificationCode(restaurantID);

        if (existingCode.isEmpty()) {
            Document verificationCodeDoc = new Document("restaurantID", restaurantID)
                    .append("code", verificationCode)
                    .append("createdTime", new Date());

            connectionManager.getCollection("Verification").insertOne(verificationCodeDoc);
        } else {
            Bson filter = Filters.eq("restaurantID", restaurantID);
            Bson update = Updates.combine(Updates.set("code", verificationCode), Updates.set("createdTime", new Date()));

            connectionManager.getCollection("Verification").updateOne(filter, update);
        }

        String emailBody = String.format("Your verification code is: %s\nThis code expire in 5 minutes", verificationCode);
        SendEmailInteractor.sendEmail(email, "Verify Your Email", emailBody);
    }

}
