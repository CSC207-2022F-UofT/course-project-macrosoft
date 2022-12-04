package database;

import entities.Restaurant;
import interactors.DBConnection;
import interactors.MongoConnection;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Collation;
import com.mongodb.client.model.CollationStrength;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class RestaurantDataProcessorMongo implements RestaurantDataGateway {
    private RestaurantDataGateway gateway;

    public RestaurantDataProcessorMongo(RestaurantDataGateway gateway) {
        this.gateway = gateway;
    }

    public String create(Restaurant restaurant) {
        return gateway.create(restaurant);
    }

    public String save(Restaurant restaurant) {
        return gateway.save(restaurant);
    }

    public String delete(Restaurant restaurant) {
        return gateway.delete(restaurant);
    }

    public String deleteByUserId(ObjectId userId) {
        return gateway.deleteByUserId(userId);
    }

    public static Restaurant getRestaurantByName(String restaurantName) {
        DBConnection dbConnection = new MongoConnection();

        Bson restaurant = Filters.eq("name", restaurantName);

        Collation collation = Collation.builder().locale("en").collationStrength(CollationStrength.TERTIARY).build();
        MongoIterable<Document> results =
                dbConnection.getCollection("Restaurants").find(restaurant).collation(collation);

        if (results.first() != null) {
            Document restaurantDocument = results.first();

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

    public Restaurant validateAndReadByUser(ObjectId userId) {
        return gateway.validateAndReadByUser(userId);
    }
}
