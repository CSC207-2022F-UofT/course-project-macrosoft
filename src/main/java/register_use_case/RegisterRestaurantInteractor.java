package register_use_case;

import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.result.InsertOneResult;
import org.bson.types.BasicBSONList;
import org.bson.types.ObjectId;
import org.bson.BsonValue;

import java.io.UnsupportedEncodingException;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

import database_access.ConnectionManager;
import entities.*;

public class RegisterRestaurantInteractor {

    private static ConnectionManager connectionManager = new ConnectionManager();

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
        // Check if username exists
        Bson filter = Filters.eq("username", restaurantName);

        if (connectionManager.getCollection("AuthInfo").find(filter).first() != null) {
            return 1001;
        }

        Document newRestaurantDoc = new Document("name", restaurantName)
                .append("email", email)
                .append("location", location)
                .append("phone", phone)
                .append("verified", false);

        InsertOneResult result = connectionManager.getCollection("Restaurants").insertOne(newRestaurantDoc);

        BsonValue restID = result.getInsertedId();
        Document newUserAuthInfo = new Document("username", restaurantName)
                .append("password", password)
                .append("userID", restID);
        connectionManager.getCollection("AuthInfo").insertOne(newUserAuthInfo);


        return 1000;
    }
}
