package verify_restaurant_use_case;

import database.*;
import entities.Restaurant;
import entities.VerificationCode;
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
    VerifyResPresenter presenter;

    public GenerateEmailInteractor(VerifyResPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * @param restaurantID: the restaurant id
     *
     */
    public void generateVerificationEmail(ObjectId restaurantID) {
        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
        VerificationCodeDataGateway dataGateway = new VerificationCodeProcessorMongo(fetcher);
        RestaurantDataGateway restaurantDataGateway = new RestaurantDataMongo(fetcher);

        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        String verificationCode = String.format("%06d", number);

        String existingCode = GetCodeInteractor.getVerificationCode(restaurantID);

        if (existingCode.isEmpty()) {
            dataGateway.save(restaurantID, new VerificationCode(new Date(), verificationCode));
        } else {
            dataGateway.update(restaurantID, new VerificationCode(new Date(), verificationCode));
        }

        Restaurant restaurant = restaurantDataGateway.findById(restaurantID);

        String emailBody = String.format("Your verification code is: %s\nThis code expire in 5 minutes", verificationCode);
        SendEmailInteractor.sendEmail(restaurant.getEmail(), "Verify Your Email", emailBody);
    }

}
