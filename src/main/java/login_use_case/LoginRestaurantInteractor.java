package login_use_case;

import entities.*;

import com.mongodb.client.*;

import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import database_access.ConnectionManager;

public class LoginRestaurantInteractor {

    private static ConnectionManager connectionManager = new ConnectionManager();
    private static Restaurant currentRestaurant = null;

    public LoginRestaurantInteractor() {}

    /**
     * @param username
     * @param password
     * @return 1000: Success
     * 1001: Not Verified
     * 1002: Invalid Credential
     */
    public static int login(String username, String password) {
        Bson queryFilter = Filters.and(
                Filters.eq("username", username),
                Filters.eq("password", password));

        MongoIterable<Document> users = connectionManager.getCollection("AuthInfo").find(queryFilter);

        if (users.first() != null) {
            Document RestDocument = users.first();
            currentRestaurant = RestaurantInfoAccessor.getRestaurantProfile(RestDocument.getObjectId("restaurantID"));

            if (!currentRestaurant.isVerified()) {
                return 1001;
            } else {
                return 1000;
            }
        }
        return 1002;
    }

    public static Restaurant getCurrentRestaurant() {
        return currentRestaurant;
    }
}
