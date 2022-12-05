package change_restaurant_info_use_case;

import org.bson.types.ObjectId;

public class ChangeRestaurantInfoRequestModel {
    private ObjectId restaurantId;
    private String newName;
    private String newEmail;
    private String newLocation;
    private String newPhone;

    public ChangeRestaurantInfoRequestModel(ObjectId restaurantId, String newName, String newEmail, String newLocation, String newPhone) {
        this.restaurantId = restaurantId;
        this.newName = newName;
        this.newEmail = newEmail;
        this.newLocation = newLocation;
        this.newPhone = newPhone;
    }

    public ObjectId getRestaurantId() {
        return restaurantId;
    }

    public String getNewName() {
        return newName;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public String getNewLocation() {
        return newLocation;
    }

    public String getNewPhone() {
        return newPhone;
    }

    public void setRestaurantId(ObjectId restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public void setNewLocation(String newLocation) {
        this.newLocation = newLocation;
    }

    public void setNewPhone(String newPhone) {
        this.newPhone = newPhone;
    }
}
