package searching_algorithm_use_case;

public class UserSearchRestaurantsController {
    private UserSearchRestaurantsInputBoundary restaurantName;

    public UserSearchRestaurantsController(UserSearchRestaurantsInputBoundary restaurantName) {
        this.restaurantName = restaurantName;
    }

    public UserSearchRestaurantsResponseModel search(String name) {
        UserSearchRestaurantsRequestModel requestModel = new UserSearchRestaurantsRequestModel(name);

        return restaurantName.search(requestModel);
    }
}
