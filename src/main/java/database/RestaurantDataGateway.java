package database;

import entities.Restaurant;
import org.bson.types.ObjectId;

import java.util.List;

public interface RestaurantDataGateway {

    ObjectId newRestaurant(String name, String email, String location, String phone);
    String save(Restaurant restaurant);
    List<Restaurant> findAll();
    Restaurant findById(ObjectId id);
    List<Restaurant> findByRestaurantName(String username);
    String getRestaurantNameById(ObjectId restId);
    void updateVerifiedStatus(ObjectId userId, Boolean newStatus);
    void updateRestaurantInfo(ObjectId restaurantID, String newName, String newEmail, String newLocation, String newPhone);
    void updateMenuId(ObjectId restaurantId, ObjectId menuId);
}
