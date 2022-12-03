package searching_algorithm_use_case;

import interactors.DBConnection;
import interactors.MongoConnection;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Collation;
import com.mongodb.client.model.CollationStrength;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import entities.*;

public class UserSearchRestaurantsInteractor {

    private static DBConnection connectionManager = new MongoConnection();

    /**
     * Searching for relevant restaurants
     * based on the user input (name of Restaurant)
     *
     * @param restaurantName: name of the restaurant
     */

    public static Restaurant getRestaurant(String restaurantName) {
        Bson restaurant = Filters.eq("name", restaurantName);

        Collation collation = Collation.builder().locale("en").collationStrength(CollationStrength.TERTIARY).build();
        MongoIterable<Document> results =
                connectionManager.getCollection("Restaurants").find(restaurant).collation(collation);

        if (results.first() != null) {
            Document restaurantDocument = results.first();

//            tester:
//            assert restaurantDocument != null;

            return new Restaurant(
                    restaurantDocument.getObjectId("_id"),
                    restaurantDocument.getString("name"),
                    restaurantDocument.getString("email"),
                    restaurantDocument.getString("location"),
                    restaurantDocument.getString("phone"),
                    restaurantDocument.getBoolean("verified"));
        }

        return null;
    }
}