package searching_algorithm_use_case;

import database.RestaurantDataGateway;

public class UserSearchRestaurantsInteractor implements UserSearchRestaurantsInputBoundary {

    private UserSearchRestaurantsPresenter presenter;

    public UserSearchRestaurantsInteractor(UserSearchRestaurantsPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Searching for relevant restaurants
     * based on the user input (name of Restaurant)
     *
     * @param requestModel: name of the restaurant
     */
    @Override
    public UserSearchRestaurantsResponseModel search(UserSearchRestaurantsRequestModel requestModel) {
        UserSearchRestaurantsResponseModel responseModel =
                new UserSearchRestaurantsResponseModel(RestaurantDataGateway.getRestaurantByName(requestModel.getName()));

        return presenter.showRestaurants(responseModel);
    }
}