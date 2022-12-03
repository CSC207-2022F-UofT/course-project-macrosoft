package Database;

import Entities.AuthInfo;
import Entities.Order;
import Interactors.DBConnection;
import Interactors.MongoConnection;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

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

        return getAuthInfo(dbConnection, queryFilter);
    }

    /**
     * @param userId
     * @param password
     * @return
     */
    @Override
    public AuthInfo getUserByUserIdPassword(ObjectId userId, String password) {
        DBConnection dbConnection = new MongoConnection();

        Bson queryFilter = Filters.and(
                Filters.eq("userID", userId),
                Filters.eq("password", password));

        return getAuthInfo(dbConnection, queryFilter);
    }

    /**
     * @param userId
     * @param newPassword
     */
    @Override
    public void setNewPassword(ObjectId userId, String newPassword) {

    }

    private AuthInfo getAuthInfo(DBConnection dbConnection, Bson queryFilter) {
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
