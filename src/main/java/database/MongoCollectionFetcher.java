package database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Fetches a MongoCollection from a MongoDatabase
 */
public class MongoCollectionFetcher {
    private static final String username = "admin";
    private static final String password = "ZUs7nwYGLnoArOPS";
    private static final String uri = String.format("mongodb+srv://%s:%s@cluster0.cyy73o0.mongodb.net/?retryWrites=true&w=majority",
            username, password);
    private final MongoClient client;
    private final MongoDatabase database;

    private static final MongoCollectionFetcher fetcher = new MongoCollectionFetcher();

    /**
     * Constructor for MongoCollectionFetcher
     */
    public MongoCollectionFetcher() {
        client = MongoClients.create(uri);
        database = client.getDatabase("SkipTheLine");
    }

    /**
     * Gets the collection with the given name
     *
     * @param collectionName the name of the collection
     * @return the MongoCollection with the given name
     */
    public MongoCollection getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }

    /**
     * Gets the MongoCollectionFetcher
     *
     * @return the MongoCollectionFetcher
     */
    public static MongoCollectionFetcher getFetcher() {
        return fetcher;
    }

    /**
     * Closes the connection to the database
     */
    public void close() {
        client.close();
    }
}
