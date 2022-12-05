package searching_algorithm_use_case;

import database.MongoCollectionFetcher;
import database.RestaurantDataGateway;
import database.RestaurantDataMongo;

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
        RestaurantDataGateway interactor = new RestaurantDataMongo(new MongoCollectionFetcher());
        UserSearchRestaurantsResponseModel responseModel =
                new UserSearchRestaurantsResponseModel(interactor.findByRestaurantName(requestModel.getName()));

        return presenter.showRestaurants(responseModel);
    }
}