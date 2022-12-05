package register_use_case;

import interactors.DBConnection;
import interactors.MongoConnection;
import com.mongodb.client.model.Filters;
import library.PasswordHasher;
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
        String hashedPassword;
        try {
            hashedPassword = PasswordHasher.toHexString(PasswordHasher.getSHA(password));
        } catch (Exception e) {
            return 1;
        }
        Document newUserAuthInfo = new Document("username", restaurantName)
                .append("password", hashedPassword)
                .append("userID", restID);
        dbConnection.getCollection("AuthInfo").insertOne(newUserAuthInfo);


        return 1000;
    }
}
