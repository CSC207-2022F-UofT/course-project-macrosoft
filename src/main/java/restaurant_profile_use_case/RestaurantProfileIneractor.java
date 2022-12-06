package restaurant_profile_use_case;

import database.*;
import entities.Restaurant;

public class RestaurantProfileIneractor implements RestaurantProfileInputBoundary{
    private RestaurantProfilePresenter presenter;

    public RestaurantProfileIneractor(RestaurantProfilePresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * @param
     */
    @Override
    public void displayRestaurantProfile(RestaurantProfileRequestModel restaurantProfileRequestModel) {
        MongoCollectionFetcher mongoCollectionFetcher = MongoCollectionFetcher.getFetcher();
        RestaurantDataGateway restaurantDataGateway = new RestaurantDataMongo(mongoCollectionFetcher);

        Restaurant restaurant = restaurantDataGateway.findById(restaurantProfileRequestModel.getRestaurantID());

        if (restaurant == null) {
            presenter.restaurantNotFound();
        }
        else {
            RestaurantProfileResponseModel restaurantProfileResponseModel = new RestaurantProfileResponseModel(restaurant.getName(), restaurant.getEmail(), restaurant.getLocation(), restaurant.getPhone());
            presenter.restaurantFound(restaurantProfileResponseModel);
        }
    }
}
