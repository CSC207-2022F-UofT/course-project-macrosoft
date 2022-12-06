package user_shopping_cart_use_case;

import database.MenuDataGateway;
import database.MenuDataMongo;
import database.MongoCollectionFetcher;
import entities.Food;
import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.List;

public class ShoppingCartInteractor implements ShoppingCartInputBoundary {
    ShoppingCartPresenter presenter;

    public ShoppingCartInteractor(ShoppingCartPresenter presenter) {
        this.presenter = presenter;
    }

    public void displayShoppingCart() {
        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
        MenuDataGateway menuDataGateway = new MenuDataMongo(fetcher);

        ObjectId restaurantId = ShoppingCartSingleton.getSingletonInstance().getRestaurantId();
        HashMap<ObjectId, Integer> cart = ShoppingCartSingleton.getSingletonInstance().getCart();

        List<Food> menu = menuDataGateway.getMenu(restaurantId).getFoodList();

        HashMap<String, Integer> cartDisplay = new HashMap<>();

        for (ObjectId foodId: cart.keySet()) {
            String name = GetFoodNameById(menu, foodId);
            if (!name.isEmpty()) {
                cartDisplay.put(name, cart.get(foodId));
            }
        }

        presenter.displayShoppingCart(cartDisplay);
    }

    public String GetFoodNameById(List<Food> menu, ObjectId foodId) {
        for (Food food: menu) {
            if (food.getItemID().toHexString().equals(foodId.toHexString())) return food.getName();
        }
        return "";
    }
}
