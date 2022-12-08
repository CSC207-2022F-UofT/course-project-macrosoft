package user_display_restaurants_use_case;

public class UserDisplayRestaurantController {
    UserDisplayRestaurantInputBoundary interactor;
    UserSearchRestaurantInputBoundary searchInteractor;

    public UserDisplayRestaurantController(UserDisplayRestaurantInputBoundary interactor, UserSearchRestaurantInputBoundary searchInteractor) {
        this.interactor = interactor;
        this.searchInteractor = searchInteractor;
    }

    public void displayAllRestaurants() {
        this.interactor.displayAllRestaurants();
    }

    public void searchRestaurant(String searchString) {
        searchInteractor.search(searchString);
    }
}
