package Entities;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/** represents the data structure of a shopping cart, temp object stored in memory, lose it if program closes*/
public class ShoppingCart {
    private ObjectId userID;

    private ObjectId restaurantID; // cart specific to the restaurant

    private List<OrderItem> items = new ArrayList<>();

    private boolean open = true;  // open or closed

    private float preTaxPayment = 0;  // changes each time add or remove an Item

    private Date lastEditTime = new Date();

    private float discountRate = 0;  // default no discount

    private float HST = (float) 0.13;  // harmonized sales tax

    public ShoppingCart(ObjectId userID, ObjectId restaurantID) {
        this.userID = userID;
        this.restaurantID = restaurantID;
    }

    /**
     * calculates and update cart's current pre-tax payment amount
     */
    private void calculatePreTaxPayment() {
        float x = 0;
        for (OrderItem item : this.items) {
            x += item.getPrice();
        }
        this.preTaxPayment = x;
    }

    public ObjectId getUserID() {
        return userID;
    }

    public void setUserID(ObjectId userID) {
        this.userID = userID;
    }

    public ObjectId getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(ObjectId restaurantID) {
        this.restaurantID = restaurantID;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public float getPreTaxPayment() {
        return preTaxPayment;
    }

    public void setPreTaxPayment(float preTaxPayment) {
        this.preTaxPayment = preTaxPayment;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

}
