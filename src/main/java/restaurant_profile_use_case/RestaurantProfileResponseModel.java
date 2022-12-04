package restaurant_profile_use_case;

public class RestaurantProfileResponseModel {
    String name;
    String email;
    String location;
    String phone;

    public RestaurantProfileResponseModel(String name, String email, String location, String phone) {
        this.name = name;
        this.email = email;
        this.location = location;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }
}
