package user_display_restaurants_use_case;

/**
 * This class is the controller for user display restaurants use case.
 */
public class UserDisplayRestaurantController {
    UserDisplayRestaurantInputBoundary interactor;
    UserSearchRestaurantInputBoundary searchInteractor;

    /**
     * Constructor for UserDisplayRestaurantController
     *
     * @param interactor       UserDisplayRestaurantInputBoundary interactor
     * @param searchInteractor UserSearchRestaurantInputBoundary search interactor
     */
    public UserDisplayRestaurantController(UserDisplayRestaurantInputBoundary interactor, UserSearchRestaurantInputBoundary searchInteractor) {
        this.interactor = interactor;
        this.searchInteractor = searchInteractor;
    }

    /**
     * Display all restaurants
     */
    public void displayAllRestaurants() {
        this.interactor.displayAllRestaurants();
    }

    /**
     * Search restaurants by name
     *
     * @param searchString String restaurant name
     */
    public void searchRestaurant(String searchString) {
        searchInteractor.search(searchString);
    }
}
