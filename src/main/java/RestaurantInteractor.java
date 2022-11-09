import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.stream.Collectors;


public class RestaurantInteractor {

    private static ConnectionManager connectionManager = new ConnectionManager();
    private static Restaurant currentRestaurant = null;

    public RestaurantInteractor(){}

    public static boolean registerRestaurant(String restaurantName, String password, String email, String location, String phone){
        Document newRestaurantDoc = new Document("name", restaurantName)
                .append("email", email)
                .append("location", location)
                .append("phone", phone);

        InsertOneResult result = connectionManager.getCollection("Restaurants").insertOne(newRestaurantDoc);

        BsonValue userID = result.getInsertedId();

        Document newUserAuthInfo = new Document("username", restaurantName)
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
            Document restaurantDocument = restaurants.first();
            currentRestaurant = getRestaurantProfile(restaurantDocument.getObjectId("userID"));

            return true;
        }
        return false;
    }

    public static Restaurant getRestaurantProfile(ObjectId restaurantID){
        Bson queryFilter = Filters.eq("_id", restaurantID);

        MongoIterable<Document> results =
                connectionManager.getCollection("Restaurants").find(queryFilter);

        if (results.first() != null) {
            Document restaurantDocument = results.first();


            Restaurant restaurant = new Restaurant(restaurantDocument.getObjectId("_id"),
                    restaurantDocument.getString("name"),
                    restaurantDocument.getString("email"),
                    restaurantDocument.getString("location"),
                    restaurantDocument.getString("phone"));

            return restaurant;
        }

        return null;
    }
}
