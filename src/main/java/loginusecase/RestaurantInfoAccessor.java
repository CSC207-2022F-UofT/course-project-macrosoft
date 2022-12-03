package loginusecase;

import interactors.DBConnection;
import interactors.MongoConnection;
import com.mongodb.client.*;

import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import entities.*;

public class RestaurantInfoAccessor {

    public static Restaurant getRestaurantProfile(ObjectId restaurantID) {
        DBConnection dbConnection = new MongoConnection();

        Bson queryFilter = Filters.eq("_id", restaurantID);

        MongoIterable<Document> results =
                dbConnection.getCollection("Restaurants").find(queryFilter);

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