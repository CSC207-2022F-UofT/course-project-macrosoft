package database;

import entities.Order;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Gateway for the Order entity to Database.
 */
public interface OrderDataGateway {
    /**
     * Creates a new order
     *
     * @param order the order to create
     * @return the id of the new order
     */
    ObjectId create(Order order);

    /**
     * Finds all orders
     *
     * @return a list of all orders
     */
    List<Order> findAll();

    /**
     * Finds all orders by user id
     *
     * @param userId the user id
     * @return a list of all orders by user id
     */
    List<Order> findAllByUser(ObjectId userId);

    /**
     * Finds all orders by restaurant id
     *
     * @param restaurantId the restaurant id
     * @return a list of all orders by restaurant id
     */
    List<Order> findAllByRestaurant(ObjectId restaurantId);

    /**
     * Finds an order by id
     *
     * @param id the id of the order
     * @return the order
     */
    Order findById(ObjectId id);

    /**
     * Updates an order status
     *
     * @param orderId   the order id
     * @param newStatus the new status of the order
     */
    void updateStatus(ObjectId orderId, String newStatus);
}
