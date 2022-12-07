package database;

import com.mongodb.client.result.InsertOneResult;
import entities.User;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * This class is responsible for all interactions with the MongoDB database
 * related to users.
 */
public class UserDataProcessorMongo implements UserDataGateway {
    MongoCollectionFetcher mongoCollectionFetcher;

    /**
     * Constructor for UserDataProcessorMongo
     *
     * @param fetcher the fetcher for the collection
     */
    public UserDataProcessorMongo(MongoCollectionFetcher fetcher) {
        this.mongoCollectionFetcher = fetcher;
    }

    /**
     * Creates a new user
     *
     * @param email     the email of the user
     * @param firstName the first name of the user
     * @param lastName  the last name of the user
     * @return the id of the new user
     */
    @Override
    public ObjectId newUser(String email, String firstName, String lastName) {

        Document newUserDoc = new Document("firstName", firstName)
                .append("lastName", lastName)
                .append("email", email)
                .append("verified", false);

        InsertOneResult result = mongoCollectionFetcher.getCollection("Users").insertOne(newUserDoc);

        BsonValue userID = result.getInsertedId();

        return userID.asObjectId().getValue();
    }

    /**
     * Gets a user from the database by id
     *
     * @param id the id of the user
     * @return the user
     */
    @Override
    public User findById(ObjectId id) {
        MongoCollection userCollection = this.mongoCollectionFetcher.getCollection("Users");

        // filter by Id
        Bson queryFilter = Filters.eq("_id", id);

        Document doc = (Document) userCollection.find(queryFilter).first();

        if (doc != null) {
            return convertDocumentToUser(doc);
        } else {
            return null;
        }
    }

    /**
     * Updates verified status of a user
     *
     * @param userId    the id of the user
     * @param newStatus the new status
     */
    @Override
    public void updateVerifiedStatus(ObjectId userId, Boolean newStatus) {
        MongoCollection userCollection = this.mongoCollectionFetcher.getCollection("Users");

        Bson queryFilter = Filters.eq("_id", userId);
        Bson update = Updates.set("verified", newStatus);
        userCollection.updateOne(queryFilter, update);
    }

    /**
     * Updates the information of a user
     *
     * @param newFirstName the new first name
     * @param newLastName  the new last name
     * @param newEmail     the new email
     */
    @Override
    public void UpdateUserInfo(ObjectId userId, String newFirstName, String newLastName, String newEmail) {
        MongoCollection userCollection = this.mongoCollectionFetcher.getCollection("Users");

        List<Bson> updates = new ArrayList<>();

        if (newFirstName != null) updates.add(Updates.set("firstName", newFirstName));
        if (newLastName != null) updates.add(Updates.set("lastName", newLastName));
        if (newEmail != null) updates.add(Updates.set("email", newEmail));

        if (updates.size() == 0) return;

        Bson queryFilter = Filters.eq("_id", userId);
        Bson update = Updates.combine(updates);

        userCollection.updateOne(queryFilter, update);
    }

    /**
     * Converts a document to a user
     *
     * @param document the document to convert
     * @return the user
     */
    public User convertDocumentToUser(Document document) {
        return new User(document.getString("firstName"),
                document.getString("lastName"),
                document.getString("email"),
                document.getObjectId("_id"),
                document.getBoolean("verified")
        );
    }
}
