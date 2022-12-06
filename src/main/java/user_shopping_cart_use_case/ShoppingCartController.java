package user_shopping_cart_use_case;

public class ShoppingCartController {
    ShoppingCartInputBoundary interactor;


    public ShoppingCartController(ShoppingCartInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void displayShoppingCart() {
        interactor.displayShoppingCart();
    }
}
