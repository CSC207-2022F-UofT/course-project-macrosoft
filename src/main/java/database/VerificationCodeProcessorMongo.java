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
    public String save(ObjectId userId, VerificationCode verificationCode) {
        Document verificationCodeDoc = new Document("userID", userId)
                .append("code", verificationCode.getCode())
                .append("createdTime", verificationCode.getCreateDate());

        this.mongoCollectionFetcher.getCollection("Verification").insertOne(verificationCodeDoc);

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

    public String update(ObjectId restaurantID, VerificationCode verificationCode) {
        Bson filter = Filters.eq("userID", restaurantID);
        Bson update = Updates.combine(
                Updates.set("code", verificationCode.getCode()),
                Updates.set("createdTime", verificationCode.getCreateDate()));

        this.mongoCollectionFetcher.getCollection("Verification").updateOne(filter, update);

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
