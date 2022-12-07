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

    private static MongoCollectionFetcher fetcher = new MongoCollectionFetcher();

    public MongoCollectionFetcher() {
        client = MongoClients.create(uri);
        database = client.getDatabase("SkipTheLine");
    }

    public MongoCollection getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }

    public static MongoCollectionFetcher getFetcher() { return fetcher; }

    public void close() {
        client.close();
    }
}
