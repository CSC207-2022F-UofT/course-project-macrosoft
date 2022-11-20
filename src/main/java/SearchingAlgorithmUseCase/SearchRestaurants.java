package SearchingAlgorithmUseCase;

import Interactors.DBConnection;
import Interactors.MongoConnection;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import Entities.*;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.stream.Collectors;

public class SearchRestaurants {

    private static DBConnection connectionManager = new MongoConnection();

    /**
     * Searching for relevant restaurants
     * based on the user input (name of Restaurant)
     *
     * @param restaurantName: name of the restaurant
     */


    public static Restaurant getRestaurant(String restaurantName) {
        restaurantName = restaurantName.toLowerCase();
        Bson restaurant = Filters.eq("name", restaurantName);

        MongoIterable<Document> results =
                connectionManager.getCollection("Restaurants").find(restaurant);

        if (results.first() != null) {
            Document restaurantDocument = results.first();

            Restaurant wantedRestaurant = new Restaurant(
                    restaurantDocument.getObjectId("_id"),
                    restaurantDocument.getString("name"),
                    restaurantDocument.getString("email"),
                    restaurantDocument.getString("location"),
                    restaurantDocument.getString("phone"),
                    restaurantDocument.getBoolean("verified"));

            return wantedRestaurant;
        }

        return null;
    }
}
