package user_shopping_cart_use_case;

import entities.Food;
import org.bson.types.ObjectId;

public class ShoppingCartInteractor implements ShoppingCartInputBoundary{

    @Override
    public void addToCart(ShoppingCartSingleton shoppingCartSingleton, ObjectId foodId, int quantity) {
        shoppingCartSingleton.getCart().put(foodId, quantity);
    }
}
