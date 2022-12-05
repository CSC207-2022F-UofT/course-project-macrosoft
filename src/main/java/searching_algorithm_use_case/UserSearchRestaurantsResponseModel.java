package searching_algorithm_use_case;

import entities.Restaurant;

import java.util.List;

public class UserSearchRestaurantsResponseModel {
    private List<Restaurant> restaurant;

    public UserSearchRestaurantsResponseModel(List<Restaurant> restaurant) {
        this.restaurant = restaurant;
    }

    public List<Restaurant> getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(List<Restaurant> restaurant) {
        this.restaurant = restaurant;
    }
}
