package database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoCollectionFetcher {
    private static final String username = "admin";
    private static final String password = "ZUs7nwYGLnoArOPS";
    private static final String uri = String.format("mongodb+srv://%s:%s@cluster0.cyy73o0.mongodb.net/?retryWrites=true&w=majority",
            username, password);
    private MongoClient client;
    private MongoDatabase database;

    public MongoCollection getCollection(String collectionName) {
        client = MongoClients.create(uri);
        database = client.getDatabase("SkipTheLine");

        return database.getCollection(collectionName);
    }
}
