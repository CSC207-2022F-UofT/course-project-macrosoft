package entities;

import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

/**
 * This class is the order entity.
 */
public class Order {
    private final ObjectId orderID;
    private final Date orderDate;
    private ObjectId restaurantID;
    private final ObjectId userID;
    private final List<OrderItem> items;
    private final String orderStatus;

    /**
     * Constructor for Order
     *
     * @param orderID      the order id
     * @param orderDate    the order date
     * @param restaurantID the restaurant id
     * @param userID       the user id
     * @param items        the list of order items
     * @param orderStatus  the order status
     */
    public Order(ObjectId orderID, Date orderDate, ObjectId restaurantID, ObjectId userID, List<OrderItem> items, String orderStatus) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.restaurantID = restaurantID;
        this.userID = userID;
        this.items = items;
        this.orderStatus = orderStatus;
    }

    /**
     * Gets the order id
     *
     * @return the order id
     */
    public ObjectId getOrderID() {
        return orderID;
    }

    /**
     * Gets the order date
     *
     * @return the order date
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Gets the restaurant id
     *
     * @return the restaurant id
     */
    public ObjectId getRestaurantID() {
        return restaurantID;
    }

    /**
     * Sets the restaurant id
     *
     * @param restaurantID the restaurant id
     */
    public void setRestaurantID(ObjectId restaurantID) {
        this.restaurantID = restaurantID;
    }

    /**
     * Gets the user id
     *
     * @return the user id
     */
    public ObjectId getUserID() {
        return userID;
    }

    /**
     * Gets the list of order items
     *
     * @return the list of order items
     */
    public List<OrderItem> getItems() {
        return items;
    }

    /**
     * Gets the order status
     *
     * @return the order status
     */
    public String getOrderStatus() {
        return orderStatus;
    }
}