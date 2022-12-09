package restaurant_profile_use_case;

import database.*;
import entities.Restaurant;

/**
 * This class is the interactor for the restaurant profile use case.
 */
public class RestaurantProfileIneractor implements RestaurantProfileInputBoundary {
    private final RestaurantProfileOutputBoundary presenter;

    /**
     * Constructor for RestaurantProfileIneractor
     *
     * @param presenter the presenter
     */
    public RestaurantProfileIneractor(RestaurantProfileOutputBoundary presenter) {
        this.presenter = presenter;
    }

    /**
     * Displays the restaurant profile.
     *
     * @param restaurantProfileRequestModel the request model
     */
    @Override
    public void displayRestaurantProfile(RestaurantProfileRequestModel restaurantProfileRequestModel) {
        MongoCollectionFetcher mongoCollectionFetcher = MongoCollectionFetcher.getFetcher();
        RestaurantDataGateway restaurantDataGateway = new RestaurantDataMongo(mongoCollectionFetcher);

        Restaurant restaurant = restaurantDataGateway.findById(restaurantProfileRequestModel.getRestaurantID());

        if (restaurant == null) {
            presenter.restaurantNotFound();
        } else {
            RestaurantProfileResponseModel restaurantProfileResponseModel = new RestaurantProfileResponseModel(restaurant.getName(), restaurant.getEmail(), restaurant.getLocation(), restaurant.getPhone());
            presenter.restaurantFound(restaurantProfileResponseModel);
        }
    }
}
