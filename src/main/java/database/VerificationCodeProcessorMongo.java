package database;

import entities.VerificationCode;
import verify_user_use_case.AddMinutesInteractor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.Date;

public class VerificationCodeProcessorMongo implements VerificationCodeDataGateway{
    MongoCollectionFetcher mongoCollectionFetcher;
    public VerificationCodeProcessorMongo(MongoCollectionFetcher fetcher) {
        this.mongoCollectionFetcher = fetcher;
    }

    /**
     * @param verificationCode
     * @return
     */
    @Override
    public String save(VerificationCode verificationCode) {
        return null;
    }

    /**
     * @param verificationCode
     * @return
     */
    @Override
    public String delete(VerificationCode verificationCode) {
        return null;
    }

    /**
     * @param verificationCode
     * @return
     */
    @Override
    public String create(VerificationCode verificationCode) {
        return null;
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public String deleteByUserId(ObjectId userId) {
        MongoCollection verificationCollection = mongoCollectionFetcher.getCollection("Verification");

        Bson filter = Filters.eq("userID", userId);
        verificationCollection.deleteOne(filter);

        return null;
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public VerificationCode validateAndReadByUser(ObjectId userId) {
        MongoCollection verificationCollection = mongoCollectionFetcher.getCollection("Verification");

        Bson filter = Filters.eq("userID", userId);

        MongoIterable<Document> results = verificationCollection.find(filter);

        if (results.first() != null) {
            Document verificationDoc = results.first();

            Date currentTime = new Date();
            Date createdTime = verificationDoc.getDate("createdTime");

            if (currentTime.compareTo(AddMinutesInteractor.addMinutesToDate(5, createdTime)) > 0) {
                verificationCollection.deleteMany(Filters.eq("userID", userId));
                return null;
            } else {
                return new VerificationCode(createdTime, verificationDoc.getString("code"));
            }
        } else {
            return null;
        }
    }
}
