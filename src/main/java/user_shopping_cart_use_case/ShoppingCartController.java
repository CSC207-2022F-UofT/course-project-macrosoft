package user_shopping_cart_use_case;

import org.bson.types.ObjectId;

public class ShoppingCartController {

    ShoppingCartInputBoundary shoppingCartInteractor;

    public ShoppingCartController(ShoppingCartInputBoundary shoppingCartInteractor) {
        this.shoppingCartInteractor = shoppingCartInteractor;
    }

    public void addToCart(ObjectId foodId, ShoppingCartSingleton shoppingCartSingleton, int quantity){
        shoppingCartInteractor.addToCart(shoppingCartSingleton, foodId, quantity);
    }
}
