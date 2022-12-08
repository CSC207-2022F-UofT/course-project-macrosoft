package user_shopping_cart_use_case;

import database.*;
import entities.Food;
import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.List;

/**
 * This class is the interactor of shopping cart use case.
 */
public class ShoppingCartInteractor implements ShoppingCartInputBoundary {
    ShoppingCartOutputBoundary presenter;

    /**
     * Constructor for ShoppingCartInteractor
     *
     * @param presenter the presenter
     */
    public ShoppingCartInteractor(ShoppingCartOutputBoundary presenter) {
        this.presenter = presenter;
    }

    /**
     * Display shopping cart.
     */
    public void displayShoppingCart() {
        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        MenuDataGateway menuDataGateway = new MenuDataMongo(fetcher);
        RestaurantDataGateway restaurantDataGateway = new RestaurantDataMongo(fetcher);

        ObjectId restaurantId = ShoppingCartSingleton.getSingletonInstance().getRestaurantId();
        HashMap<ObjectId, Integer> cart = ShoppingCartSingleton.getSingletonInstance().getCart();

        if (restaurantId == null) {
            presenter.displayShoppingCart(null, new HashMap<>());
            return;
        }

        String restaurantName = restaurantDataGateway.getRestaurantNameById(restaurantId);

        List<Food> menu = menuDataGateway.getMenu(restaurantId).getFoodList();

        HashMap<String, HashMap<String, Object>> cartDisplay = new HashMap<>();

        for (ObjectId foodId : cart.keySet()) {
            String name = GetFoodNameById(menu, foodId);
            if (!name.isEmpty()) {

                HashMap<String, Object> map = new HashMap<>();
                map.put("id", foodId);
                map.put("quantity", cart.get(foodId));
                cartDisplay.put(name, map);
            }
        }

        presenter.displayShoppingCart(restaurantName, cartDisplay);
    }

    /**
     * Gets food name by id.
     *
     * @param menu   the menu
     * @param foodId the food id
     * @return the food name by id
     */
    public String GetFoodNameById(List<Food> menu, ObjectId foodId) {
        for (Food food : menu) {
            if (food.getItemID().toHexString().equals(foodId.toHexString())) return food.getName();
        }
        return "";
    }
}
