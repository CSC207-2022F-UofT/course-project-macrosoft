package interactors;

import com.mongodb.client.MongoCollection;

public interface DBConnection {
    public MongoCollection getCollection(String collectionName);
}
