package Entities;

import Entities.*;
import org.bson.types.ObjectId;

public class Restaurant {

    private ObjectId restaurantID;

    private String name;

    private String email;

    private String location;

    private String phone;

    private boolean verified;


    public Restaurant(ObjectId restaurantID, String name, String email, String location, String phone, boolean verified) {
        this.restaurantID = restaurantID;
        this.name = name;
        this.email = email;
        this.location = location;
        this.phone = phone;
        this.verified = verified;
    }

    public ObjectId getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(ObjectId restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}

