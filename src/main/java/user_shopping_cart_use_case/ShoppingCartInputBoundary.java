package user_shopping_cart_use_case;

import entities.Food;
import org.bson.types.ObjectId;

public interface ShoppingCartInputBoundary {
    void addToCart(ShoppingCartSingleton shoppingCartSingleton, ObjectId foodId, int quantity);
}
