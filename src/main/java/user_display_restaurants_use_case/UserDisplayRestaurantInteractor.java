package user_display_restaurants_use_case;

import database.MongoCollectionFetcher;
import database.RestaurantDataGateway;
import database.RestaurantDataMongo;
import entities.Restaurant;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * This class is the interactor for user display restaurants use case.
 */
public class UserDisplayRestaurantInteractor implements UserDisplayRestaurantInputBoundary {
    UserDisplayRestaurantPresenter presenter;

    /**
     * Constructor for UserDisplayRestaurantInteractor
     *
     * @param presenter UserDisplayRestaurantPresenter presenter
     */
    public UserDisplayRestaurantInteractor(UserDisplayRestaurantPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Display all restaurants
     */
    public void displayAllRestaurants() {
        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        RestaurantDataGateway restaurantDataGateway = new RestaurantDataMongo(fetcher);

        List<Restaurant> restaurantList = restaurantDataGateway.findAll();

        HashMap<ObjectId, String> restaurantInfo = new HashMap<>();

        for (Restaurant restaurant : restaurantList) {
            restaurantInfo.put(restaurant.getRestaurantID(), restaurant.getName());
        }

        presenter.displayRestaurants(restaurantInfo);
    }
}
