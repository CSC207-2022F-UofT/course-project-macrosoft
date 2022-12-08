package restaurant_profile_use_case;

/**
 * This class is the response model for the restaurant profile use case.
 */
public class RestaurantProfileResponseModel {
    String name;
    String email;
    String location;
    String phone;

    /**
     * Constructor for RestaurantProfileResponseModel
     *
     * @param name     the name
     * @param email    the email
     * @param location the location
     * @param phone    the phone
     */
    public RestaurantProfileResponseModel(String name, String email, String location, String phone) {
        this.name = name;
        this.email = email;
        this.location = location;
        this.phone = phone;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
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
     * Gets the location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets the phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }
}
