package restaurant_register_use_case;

/**
 * This class is the request model for the restaurant register use case.
 */
public class RegisterRestaurantRequestModel {
    private String restaurantName;
    private String username;
    private String password;
    private String email;
    private String location;
    private String phone;

    /**
     * Constructor for RegisterRestaurantRequestModel
     *
     * @param restaurantName the restaurant name
     * @param username       the username
     * @param password       the password
     * @param email          the email
     * @param location       the location
     * @param phone          the phone
     */
    public RegisterRestaurantRequestModel(String restaurantName, String username, String password, String email, String location, String phone) {
        this.restaurantName = restaurantName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.location = location;
        this.phone = phone;
    }

    /**
     * Gets the restaurant name.
     *
     * @return the restaurant name
     */
    public String getRestaurantName() {
        return restaurantName;
    }

    /**
     * Sets the restaurant name.
     *
     * @param restaurantName the restaurant name
     */
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location.
     *
     * @param location the location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
