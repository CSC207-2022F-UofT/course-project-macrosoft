package database;

import com.mongodb.client.model.Updates;
import entities.VerificationCode;
import user_verify_use_case.AddMinutesInteractor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.Date;

/**
 * This class is responsible for all interactions with the MongoDB database
 * related to verification codes.
 */
public class VerificationCodeProcessorMongo implements VerificationCodeDataGateway {
    MongoCollectionFetcher mongoCollectionFetcher;

    /**
     * Constructor for VerificationCodeProcessorMongo
     *
     * @param fetcher the fetcher for the collection
     */
    public VerificationCodeProcessorMongo(MongoCollectionFetcher fetcher) {
        this.mongoCollectionFetcher = fetcher;
    }

    /**
     * Saves a verification code to the database with the given user id
     *
     * @param userId           the id of the user
     * @param verificationCode the verification code to be saved
     */
    @Override
    public void save(ObjectId userId, VerificationCode verificationCode) {
        Document verificationCodeDoc = new Document("userID", userId)
                .append("code", verificationCode.getCode())
                .append("createdTime", verificationCode.getCreateDate());

        this.mongoCollectionFetcher.getCollection("Verification").insertOne(verificationCodeDoc);
    }

    /**
     * Deletes a verification code from the database with the given user id
     *
     * @param userId the id of the user
     */
    @Override
    public void deleteByUserId(ObjectId userId) {
        MongoCollection verificationCollection = mongoCollectionFetcher.getCollection("Verification");

        Bson filter = Filters.eq("userID", userId);
        verificationCollection.deleteOne(filter);
    }

    /**
     * Updates the verification code in the database with the given user id
     *
     * @param userID           the id of the user
     * @param verificationCode the verification code to be updated
     */
    public void update(ObjectId userID, VerificationCode verificationCode) {
        Bson filter = Filters.eq("userID", userID);
        Bson update = Updates.combine(
                Updates.set("code", verificationCode.getCode()),
                Updates.set("createdTime", verificationCode.getCreateDate()));

        this.mongoCollectionFetcher.getCollection("Verification").updateOne(filter, update);
    }

    /**
     * Validates and reads the verification code from the database with the given user id
     *
     * @param userId the id of the user
     * @return the verification code
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
