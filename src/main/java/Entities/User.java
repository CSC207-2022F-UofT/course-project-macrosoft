package Entities;

import org.bson.types.ObjectId;

import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private ObjectId userId;
    private List<ObjectId> orderIds;
    private boolean verified;

    public User(String firstName, String lastName, String email, ObjectId userId, List<ObjectId> orderIds, boolean verified) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userId = userId;
        this.orderIds = orderIds;
        this.verified = verified;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public List<ObjectId> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<ObjectId> orderIds) {
        this.orderIds = orderIds;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
