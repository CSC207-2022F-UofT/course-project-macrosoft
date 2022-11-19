package RegisterUseCase;

import Interactors.DBConnection;
import Interactors.MongoConnection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.result.InsertOneResult;
import org.bson.BsonValue;

public class RegisterRestaurantInteractor {

    public RegisterRestaurantInteractor() {}

    /**
     * @param restaurantName
     * @param password
     * @param email
     * @param location
     * @param phone
     * @return 1000: Success
     * 1001: Username Exists
     */
    public static int registerRestaurant(String restaurantName, String password, String email, String location, String phone){
        DBConnection dbConnection = new MongoConnection();

        // Check if username exists
        Bson filter = Filters.eq("username", restaurantName);

        if (dbConnection.getCollection("AuthInfo").find(filter).first() != null) {
            return 1001;
        }

        Document newRestaurantDoc = new Document("name", restaurantName)
                .append("email", email)
                .append("location", location)
                .append("phone", phone)
                .append("verified", false);

        InsertOneResult result = dbConnection.getCollection("Restaurants").insertOne(newRestaurantDoc);

        BsonValue restID = result.getInsertedId();
        Document newUserAuthInfo = new Document("username", restaurantName)
                .append("password", password)
                .append("userID", restID);
        dbConnection.getCollection("AuthInfo").insertOne(newUserAuthInfo);


        return 1000;
    }
}
