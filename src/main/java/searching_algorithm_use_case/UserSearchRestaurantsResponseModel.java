package searching_algorithm_use_case;

import entities.Restaurant;

public class UserSearchRestaurantsResponseModel {
    private Restaurant restaurant;

    public UserSearchRestaurantsResponseModel(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
