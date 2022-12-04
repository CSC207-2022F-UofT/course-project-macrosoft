package database;

import entities.User;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class UserDataProcessorMongo implements UserDataGateway {
    MongoCollectionFetcher mongoCollectionFetcher;
    public UserDataProcessorMongo(MongoCollectionFetcher fetcher) {
        this.mongoCollectionFetcher = fetcher;
    }

    /**
     * insert the User into MongoDB as a document
     * @param user
     * @return
     */
    @Override
    public String save(User user) {
        this.mongoCollectionFetcher.getCollection("Users").insertOne(convertUserToDocument(user));
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> lst = new ArrayList<>();
        this.mongoCollectionFetcher.getCollection("Users")
                .find()  // finds all documents in an iterator
                .forEach(doc -> lst.add(convertDocumentToUser((Document) doc)));
        return lst;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public User findById(ObjectId id) {
        MongoCollection userCollection = this.mongoCollectionFetcher.getCollection("Users");

        // filter by Id
        Bson queryFilter = Filters.eq("_id", id);

        Document doc = (Document) userCollection.find(queryFilter).first();

        if (doc != null) {return convertDocumentToUser(doc);}
        else {return null;}
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public User findByUsernamePassword(String username, String password) {
        MongoCollection userCollection = this.mongoCollectionFetcher.getCollection("Users");
        // filter by Id
        Bson queryFilter = Filters.eq("username", username);

        Document doc = (Document) userCollection.find(queryFilter).first();

        if (doc != null) {return convertDocumentToUser(doc);}
        else {return null;}
    }

    /**
     * @param userId
     * @param newStatus
     * @return
     */
    @Override
    public String updateVerifiedStatus(ObjectId userId, Boolean newStatus) {
        MongoCollection userCollection = this.mongoCollectionFetcher.getCollection("Users");

        Bson queryFilter = Filters.eq("_id", userId);
        Bson update = Updates.set("verified", newStatus);
        userCollection.updateOne(queryFilter, update);

        return null;
    }

    /**
     * @param newFirstName
     * @param newLastName
     * @param newEmail
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

    @Override
    public boolean getVerifiedStatus(ObjectId userId) {
        MongoCollection userCollection = this.mongoCollectionFetcher.getCollection("Users");
        Bson queryFilter = Filters.eq("_id", userId);

        Document doc = (Document) userCollection.find(queryFilter).first();

        return doc.getBoolean("verified");
    }

    public User convertDocumentToUser(Document document) {
        return new User(document.getString("firstName"),
                document.getString("lastName"),
                document.getString("email"),
                document.getObjectId("_id"),
                document.getBoolean("verified")
        );
    }

    public Document convertUserToDocument(User user) {
        return null;
    }


}
