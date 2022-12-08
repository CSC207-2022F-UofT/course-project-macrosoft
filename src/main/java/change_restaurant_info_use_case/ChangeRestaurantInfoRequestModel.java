package change_restaurant_info_use_case;

import org.bson.types.ObjectId;

/**
 * This class is the request model for the change restaurant information use case.
 */
public class ChangeRestaurantInfoRequestModel {
    private ObjectId restaurantId;
    private String newName;
    private String newEmail;
    private String newLocation;
    private String newPhone;

    /**
     * Constructor for ChangeRestaurantInfoRequestModel
     *
     * @param restaurantId the restaurant id
     * @param newName      the new name of the restaurant
     * @param newEmail     the new email address of the restaurant
     * @param newLocation  the new location of the restaurant
     * @param newPhone     the new phone of the restaurant
     */
    public ChangeRestaurantInfoRequestModel(ObjectId restaurantId, String newName, String newEmail, String newLocation, String newPhone) {
        this.restaurantId = restaurantId;
        this.newName = newName;
        this.newEmail = newEmail;
        this.newLocation = newLocation;
        this.newPhone = newPhone;
    }

    /**
     * Gets the restaurant id
     *
     * @return the restaurant id
     */
    public ObjectId getRestaurantId() {
        return restaurantId;
    }

    /**
     * Gets the new name of the restaurant
     *
     * @return the new name of the restaurant
     */
    public String getNewName() {
        return newName;
    }

    /**
     * Gets the new email of the restaurant
     *
     * @return the new email of the restaurant
     */
    public String getNewEmail() {
        return newEmail;
    }

    /**
     * Gets the new location of the restaurant
     *
     * @return the new location of the restaurant
     */
    public String getNewLocation() {
        return newLocation;
    }

    /**
     * Gets the new phone number of the restaurant
     *
     * @return the new phone number of the restaurant
     */
    public String getNewPhone() {
        return newPhone;
    }

    /**
     * Sets the id of the restaurant
     *
     * @param restaurantId the id of the restaurant
     */
    public void setRestaurantId(ObjectId restaurantId) {
        this.restaurantId = restaurantId;
    }

    /**
     * Sets the new name of the restaurant
     *
     * @param newName the new name of the restaurant
     */
    public void setNewName(String newName) {
        this.newName = newName;
    }

    /**
     * Sets the new email of the restaurant
     *
     * @param newEmail the new email of the restaurant
     */
    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    /**
     * Sets the new location of the restaurant
     *
     * @param newLocation the new location of the restaurant
     */
    public void setNewLocation(String newLocation) {
        this.newLocation = newLocation;
    }

    /**
     * Sets the new phone number of the restaurant
     *
     * @param newPhone the new phone number of the restaurant
     */
    public void setNewPhone(String newPhone) {
        this.newPhone = newPhone;
    }
}
