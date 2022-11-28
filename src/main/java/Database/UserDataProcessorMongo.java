package Database;

import Entities.User;

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
    public User findById(String id) {
        MongoCollection userCollection = this.mongoCollectionFetcher.getCollection("Users");

        // id is a hexString, convert to ObjectId
        ObjectId _id = new ObjectId(id);

        // filter by Id
        Bson queryFilter = Filters.eq("_id", _id);

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

    public User convertDocumentToUser(Document document) {
        return null;
    }

    public Document convertUserToDocument(User user) {
        return null;
    }


}
