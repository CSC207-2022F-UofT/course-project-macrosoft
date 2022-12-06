package database;

import entities.Order;
import org.bson.types.ObjectId;

import java.util.List;

public interface OrderDataGateway {
    String save(Order order);
    String delete(Order order);
    String create(Order order);
    List<Order> findAll();
    List<Order> findAllByUser(ObjectId userId);
    List<Order> findAllByRestaurant(ObjectId restaurantId);
    Order findById(ObjectId id);

    void updateOrderStatus(ObjectId orderId, String newStatus);
}
