package restaurant_register_use_case;

public class RegisterRestaurantRequestModel {
    private String restaurantName;
    private String username;
    private String password;
    private String email;
    private String location;
    private String phone;

    public RegisterRestaurantRequestModel(String restaurantName, String username, String password, String email, String location, String phone) {
        this.restaurantName = restaurantName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.location = location;
        this.phone = phone;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
