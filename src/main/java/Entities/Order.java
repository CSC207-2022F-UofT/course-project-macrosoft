package Entities;

import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

public class Order {
    private ObjectId orderID;
    private Date orderDate;
    private ObjectId restaurantID;
    private ObjectId userID;
    private List<OrderItem> items;
    private String orderStatus;

    public Order(ObjectId orderID, Date orderDate, ObjectId restaurantID, ObjectId userID, List<OrderItem> items, String orderStatus) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.restaurantID = restaurantID;
        this.userID = userID;
        this.items = items;
        this.orderStatus = orderStatus;
    }

    public ObjectId getOrderID() {
        return orderID;
    }

    public void setOrderID(ObjectId orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public ObjectId getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(ObjectId restaurantID) {
        this.restaurantID = restaurantID;
    }

    public ObjectId getUserID() {
        return userID;
    }

    public void setUserID(ObjectId userID) {
        this.userID = userID;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
