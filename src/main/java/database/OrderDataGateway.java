package database;

import entities.Order;
import org.bson.types.ObjectId;

import java.util.Dictionary;
import java.util.List;

public interface OrderDataGateway {
    void save(Dictionary<ObjectId, Integer> orderList);
    void delete(Dictionary<ObjectId, Integer> orderList);
    void create(Dictionary<ObjectId, Integer> orderList, ObjectId resId, ObjectId userId);
    List<Order> findAll();
    List<Order> findAllByUser(ObjectId userId);
    List<Order> findAllByRestaurant(ObjectId restaurantId);
    Order findById(ObjectId id);
}
