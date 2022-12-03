package database;

import entities.AuthInfo;
import entities.Order;
import interactors.DBConnection;
import interactors.MongoConnection;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

public class AuthInfoProcessorMongo implements AuthInfoDataGateway{
    MongoCollectionFetcher mongoCollectionFetcher;

    public AuthInfoProcessorMongo(MongoCollectionFetcher fetcher) {
        this.mongoCollectionFetcher = fetcher;
    }

    /**
     * @param order
     * @return
     */
    @Override
    public String save(Order order) {
        return null;
    }

    /**
     * @param order
     * @return
     */
    @Override
    public String delete(Order order) {
        return null;
    }

    /**
     * @param order
     * @return
     */
    @Override
    public String create(Order order) {
        return null;
    }

    /**
     * @param username
     * @param password
     * @return
     */
    @Override
    public AuthInfo getUserByUsernamePassword(String username, String password) {
        DBConnection dbConnection = new MongoConnection();

        Bson queryFilter = Filters.and(
                Filters.eq("username", username),
                Filters.eq("password", password));

        MongoIterable<Document> users = dbConnection.getCollection("AuthInfo").find(queryFilter);

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
