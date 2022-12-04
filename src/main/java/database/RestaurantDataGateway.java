package database;

import entities.Restaurant;
import org.bson.types.ObjectId;

public interface RestaurantDataGateway {
    String save(Restaurant restaurant);
    String delete(Restaurant restaurant);
    String create(Restaurant restaurant);
    String deleteByUserId(ObjectId userId);

    static Restaurant getRestaurantByName(String restaurantName) {
        return null;
    }

    Restaurant validateAndReadByUser(ObjectId userId);
}
