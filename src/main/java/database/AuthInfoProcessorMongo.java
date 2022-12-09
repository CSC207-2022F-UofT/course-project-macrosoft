package database;

import com.mongodb.MongoException;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import entities.AuthInfo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * This class is responsible for all interactions with the MongoDB database
 * related to authentication information.
 */
public class AuthInfoProcessorMongo implements AuthInfoDataGateway {
    MongoCollectionFetcher mongoCollectionFetcher;

    /**
     * Constructor for AuthInfoProcessorMongo
     *
     * @param fetcher the fetcher for the collection
     */
    public AuthInfoProcessorMongo(MongoCollectionFetcher fetcher) {
        this.mongoCollectionFetcher = fetcher;
    }

    /**
     * Creates a new authentication information
     *
     * @param username the username of the user
     * @param password the password of the user
     * @param userId  the id of the user
     */
    @Override
    public void create(String username, String password, ObjectId userId) {
        Document newUserAuthInfo = new Document("username", username)
                .append("password", password)
                .append("userID", userId);

        mongoCollectionFetcher.getCollection("AuthInfo").insertOne(newUserAuthInfo);
    }

    /**
     * Gets user by username and password
     *
     * @param username the username of the user
     * @param password the password of the user
     * @return the user
     */
    @Override
    public AuthInfo getUserByUsernamePassword(String username, String password) {
        Bson queryFilter = Filters.and(
                Filters.eq("username", username),
                Filters.eq("password", password));

        return getAuthInfo(queryFilter);
    }

    /**
     * Get user by user id and password
     *
     * @param userId   the id of the user
     * @param password the password of the user
     * @return the user
     */
    @Override
    public AuthInfo getUserByUserIdPassword(ObjectId userId, String password) {
        Bson queryFilter = Filters.and(
                Filters.eq("userID", userId),
                Filters.eq("password", password));

        return getAuthInfo(queryFilter);
    }

    /**
     * Gets user by username
     *
     * @param username the username of the user
     * @return the user
     */
    @Override
    public AuthInfo getUserByUsername(String username) {
        Bson queryFilter = Filters.eq("username", username);

        return getAuthInfo(queryFilter);
    }

    @Override
    public void removeByUsername(String username) {
        Bson filter = Filters.eq("username", username);
        MongoCollection collection = mongoCollectionFetcher.getCollection("AuthInfo");
        collection.deleteOne(filter);
    }

    /**
     * Sets a new password for a user
     *
     * @param userId      the id of the user
     * @param newPassword the new password
     * @return a string shows the result
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

    /**
     * Gets the AuthInfo from the database
     *
     * @param queryFilter the filter for the query
     * @return the AuthInfo
     */
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
