package database;

import entities.Restaurant;
import org.bson.types.ObjectId;

import java.util.List;

public interface RestaurantDataGateway {

    String save(Restaurant restaurant);
    List<Restaurant> findAll();
    Restaurant findById(ObjectId id);
    Restaurant findByRestaurantNamePassword(String username, String password);
    void updateVerifiedStatus(ObjectId userId, Boolean newStatus);
    void UpdateRestaurantInfo(ObjectId restaurantID, String newName, String newEmail, String newLocation, String newPhone);
}
