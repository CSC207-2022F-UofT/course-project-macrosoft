package Database;

import Entities.OrderItem;
import Entities.User;
import Interactors.MongoConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class UserDataMongo implements UserDataGateway {
    MongoCollectionFetcher mongoCollectionFetcher;
    public UserDataMongo() {
        this.mongoCollectionFetcher = new MongoCollectionFetcher();
    }

    @Override
    public String save(User user) {
        MongoCollection userCollection = this.mongoCollectionFetcher.getCollection("Users");
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

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

    @Override
    public User findByUsernamePassword(String username, String password) {
        MongoCollection userCollection = this.mongoCollectionFetcher.getCollection("Users");
        // filter by Id
        Bson queryFilter = Filters.eq("username", username);

        Document doc = (Document) userCollection.find(queryFilter).first();

        if (doc != null) {return convertDocumentToUser(doc);}
        else {return null;}
    }

    public User convertDocumentToUser(Document document) {
        return null;
    }

    public Document convertUserToDocument(User user) {
        return null;
    }
}
