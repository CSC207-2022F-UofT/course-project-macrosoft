package login_use_case;
import database_access.ConnectionManager;
import entities.*;

import com.mongodb.client.*;

import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;


public class RestaurantInfoAccessor {

    private static ConnectionManager connectionManager = new ConnectionManager();

    public static Restaurant getRestaurantProfile(ObjectId restaurantID) {
        Bson queryFilter = Filters.eq("_id", restaurantID);

        MongoIterable<Document> results =
                connectionManager.getCollection("Restaurants").find(queryFilter);

        if (results.first() != null) {
            Document restaurantDocument = results.first();

            Restaurant restaurant = new Restaurant(restaurantDocument.getObjectId("_id"),
                    restaurantDocument.getString("name"),
                    restaurantDocument.getString("email"),
                    restaurantDocument.getString("location"),
                    restaurantDocument.getString("phone"),
                    restaurantDocument.getBoolean("verified"));

            return restaurant;
        }

        return null;
    }
}