package user_display_restaurants_use_case;

public class UserDisplayRestaurantController {
    UserDisplayRestaurantInputBoundary interactor;

    public UserDisplayRestaurantController(UserDisplayRestaurantInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void displayAllRestaurants() {
        this.interactor.displayAllRestaurants();
    }
}
