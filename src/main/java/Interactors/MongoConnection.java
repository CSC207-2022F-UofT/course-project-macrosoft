package Interactors;

import com.mongodb.MongoException;
import com.mongodb.client.*;

import java.util.HashMap;

public class MongoConnection implements DBConnection {
    private static final String username = "admin";
    private static final String password = "ZUs7nwYGLnoArOPS";
    private static final String uri = String.format("mongodb+srv://%s:%s@cluster0.cyy73o0.mongodb.net/?retryWrites=true&w=majority",
            username, password);
    private MongoClient client;
    private MongoDatabase database;
    private HashMap<String, MongoCollection> collections;

    public MongoConnection() {
        try {
            client = MongoClients.create(uri);
            database = client.getDatabase("SkipTheLine");
            collections = new HashMap<String, MongoCollection>();

            collections.put("AuthInfo", database.getCollection("AuthInfo"));
            collections.put("Users", database.getCollection("Users"));
            collections.put("Orders", database.getCollection("Orders"));
            collections.put("Restaurants", database.getCollection("Restaurants"));
            collections.put("Verification", database.getCollection("Verification"));
        } catch (MongoException me) {
            System.err.println("An error occurred while attempting to run a command: " + me);
        }
    }

    public MongoCollection getCollection(String collectionName) {
        return collections.get(collectionName);
    }
}
