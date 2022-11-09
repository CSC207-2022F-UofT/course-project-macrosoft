import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class CustomerInteractor {

    private static ConnectionManager connectionManager = new ConnectionManager();
    private static Customer currentCustomer = null;

    public CustomerInteractor() {}

    public static boolean registerCustomer(String customerName, String email, String password){
        Document newCustomerDoc = new Document("Name", customerName)
                .append("email", email);

        InsertOneResult result = connectionManager.getCollection("Customers").insertOne(newCustomerDoc);

        BsonValue userID = result.getInsertedId();

        Document newUserAuthInfo = new Document("username", customerName)
                .append("password", password)
                .append("UserID", userID);

        connectionManager.getCollection("AuthInfo").insertOne(newUserAuthInfo);

        return true;
    }

    public static boolean login(String username, String password) {
        Bson queryFilter = Filters.and(
                Filters.eq("username", username),
                Filters.eq("password", password));

        MongoIterable<Document> restaurants = connectionManager.getCollection("AuthInfo").find(queryFilter);

        if (restaurants.first() != null){
            Document customerDocument = restaurants.first();
                currentCustomer = getCustomerProfile(customerDocument.getObjectId("userID"));

            return true;
        }
        return false;
    }

    public static Customer getCustomerProfile(ObjectId CustomerID){
        Bson queryFilter = Filters.eq("_id", CustomerID);

        MongoIterable<Document> results =
                connectionManager.getCollection("Customers").find(queryFilter);

        if (results.first() != null) {
            Document customerDocument = results.first();


            Customer customer = new Customer(customerDocument.getString("name"),
                    customerDocument.getString("email"),
                    customerDocument.getObjectId("_id"));

            return customer;
        }

        return null;
    }
}
