package entities;

import org.bson.types.ObjectId;

/**
 * This class is the user entity.
 */
public class Restaurant {

    private ObjectId restaurantID;

    private String name;

    private String email;

    private String location;

    private String phone;

    private final boolean verified;

    /**
     * Constructor for Restaurant
     *
     * @param restaurantID the restaurant id
     * @param name         the name of the restaurant
     * @param email        the email of the restaurant
     * @param location     the location of the restaurant
     * @param phone        the phone number of the restaurant
     * @param verified     the verification status of the restaurant
     */
    public Restaurant(ObjectId restaurantID, String name, String email, String location, String phone, boolean verified) {
        this.restaurantID = restaurantID;
        this.name = name;
        this.email = email;
        this.location = location;
        this.phone = phone;
        this.verified = verified;
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
     * Gets the name of the restaurant
     *
     * @return the name of the restaurant
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the restaurant
     *
     * @param name the name of the restaurant
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email of the restaurant
     *
     * @return the email of the restaurant
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the restaurant
     *
     * @param email the email of the restaurant
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the location of the restaurant
     *
     * @return the location of the restaurant
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the restaurant
     *
     * @param location the location of the restaurant
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the phone number of the restaurant
     *
     * @return the phone number of the restaurant
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the restaurant
     *
     * @param phone the phone number of the restaurant
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the verification status of the restaurant
     *
     * @return the verification status of the restaurant
     */
    public boolean isVerified() {
        return verified;
    }
}

