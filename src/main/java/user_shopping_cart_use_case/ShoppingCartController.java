package user_shopping_cart_use_case;

import org.bson.types.ObjectId;

public class ShoppingCartController {
    ShoppingCartInputBoundary interactor;


    public ShoppingCartController(ShoppingCartInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void displayShoppingCart() {
        interactor.displayShoppingCart();
    }
    public void deleteItem(ObjectId foodId) {
        ShoppingCartSingleton.getSingletonInstance().getCart().remove(foodId);
    }
}
