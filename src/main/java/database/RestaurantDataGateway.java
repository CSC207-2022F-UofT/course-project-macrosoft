package database;

import entities.Restaurant;
import org.bson.types.ObjectId;

import java.util.List;

public interface RestaurantDataGateway {

    String save(Restaurant restaurant);
    List<Restaurant> findAll();
    Restaurant findById(ObjectId id);
    List<Restaurant> findByRestaurantName(String username);
    String getRestaurantNameById(ObjectId restId);
    void updateVerifiedStatus(ObjectId userId, Boolean newStatus);
    void UpdateRestaurantInfo(ObjectId restaurantID, String newName, String newEmail, String newLocation, String newPhone);
}
