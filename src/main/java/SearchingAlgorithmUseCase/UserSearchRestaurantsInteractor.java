package SearchingAlgorithmUseCase;

import Interactors.DBConnection;
import Interactors.MongoConnection;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Collation;
import com.mongodb.client.model.CollationStrength;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import Entities.*;

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