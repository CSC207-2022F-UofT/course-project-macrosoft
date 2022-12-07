package user_display_restaurants_use_case;

import database.MongoCollectionFetcher;
import database.RestaurantDataGateway;
import database.RestaurantDataMongo;
import entities.Restaurant;
import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.List;

public class UserSearchRestaurantInteractor implements UserSearchRestaurantInputBoundary {
    UserDisplayRestaurantPresenter presenter;

    public UserSearchRestaurantInteractor(UserDisplayRestaurantPresenter presenter) {
        this.presenter = presenter;
    }

    public void search(String searchString) {
        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        RestaurantDataGateway restaurantDataGateway = new RestaurantDataMongo(fetcher);

        List<Restaurant> restaurantList = restaurantDataGateway.findByRestaurantName(searchString);

        HashMap<ObjectId, String> restaurantInfo = new HashMap<>();

        for (Restaurant restaurant: restaurantList) {
            restaurantInfo.put(restaurant.getRestaurantID(), restaurant.getName());
        }

        presenter.displayRestaurants(restaurantInfo);
    }
}
