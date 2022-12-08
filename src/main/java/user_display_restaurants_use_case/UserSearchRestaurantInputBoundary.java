package user_display_restaurants_use_case;

/**
 * This interface is the input boundary of the user search restaurants.
 */
public interface UserSearchRestaurantInputBoundary {
    /**
     * Search restaurants by name
     *
     * @param searchString String restaurant name
     */
    void search(String searchString);
}
