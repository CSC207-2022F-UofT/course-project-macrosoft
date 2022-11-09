import org.bson.types.ObjectId;

import java.util.List;

public class Restaurant {
    private ObjectId restaurantID;

    private String name;

    private String email;

    private String location;

    private String phone;

    private Menu menu;

    public Restaurant(ObjectId restaurantID, String name, String email, String location, String phone, Menu menu) {
        this.restaurantID = restaurantID;
        this.name = name;
        this.email = email;
        this.location = location;
        this.phone = phone;
        this.menu = menu;
    }

    public Restaurant(ObjectId restaurantID, String name, String email, String location, String phone) {
        this.restaurantID = restaurantID;
        this.name = name;
        this.email = email;
        this.location = location;
        this.phone = phone;
        this.menu = null;
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
