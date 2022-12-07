package database;

import com.mongodb.MongoException;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import entities.AuthInfo;
import entities.Order;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class AuthInfoProcessorMongo implements AuthInfoDataGateway{
    MongoCollectionFetcher mongoCollectionFetcher;

    public AuthInfoProcessorMongo(MongoCollectionFetcher fetcher) {
        this.mongoCollectionFetcher = fetcher;
    }

    /**
     * @param order
     * @return
     */
    @Override
    public String save(Order order) {
        return null;
    }


    @Override
    public String create(String username, String password, ObjectId userId) {
        Document newUserAuthInfo = new Document("username", username)
                .append("password", password)
                .append("userID", userId);

        mongoCollectionFetcher.getCollection("AuthInfo").insertOne(newUserAuthInfo);
        return null;
    }

    /**
     * @param username
     * @param password
     * @return
     */
    @Override
    public AuthInfo getUserByUsernamePassword(String username, String password) {
        Bson queryFilter = Filters.and(
                Filters.eq("username", username),
                Filters.eq("password", password));

        return getAuthInfo(queryFilter);
    }

    /**
     * @param userId
     * @param password
     * @return
     */
    @Override
    public AuthInfo getUserByUserIdPassword(ObjectId userId, String password) {
        Bson queryFilter = Filters.and(
                Filters.eq("userID", userId),
                Filters.eq("password", password));

        return getAuthInfo(queryFilter);
    }

    @Override
    public AuthInfo getUserByUsername(String username) {
        Bson queryFilter = Filters.eq("username", username);

        return getAuthInfo(queryFilter);
    }

    /**
     * @param userId
     * @param newPassword
     */
    @Override
    public String setNewPassword(ObjectId userId, String newPassword) {
        Bson query = Filters.eq("userID", userId);
        Bson updates = Updates.set("password", newPassword);

        try {
            UpdateResult result = mongoCollectionFetcher.getCollection("AuthInfo")
                    .updateOne(query, updates);

            return "Success";
        } catch (MongoException me) {
            return "Unable to update due to an error: " + me;
        }
    }

    private AuthInfo getAuthInfo(Bson queryFilter) {
        MongoIterable<Document> users = mongoCollectionFetcher.getCollection("AuthInfo").find(queryFilter);

        if (users.first() == null)
            return null;
        else {
            Document document = users.first();

            return new AuthInfo(document.getString("username"),
                    document.getString("password"),
                    document.getObjectId("userID"));
        }
    }
}
