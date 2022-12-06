package user_shopping_cart_use_case;

import java.util.HashMap;

public class ShoppingCartProcessor implements ShoppingCartPresenter {

    ShoppingCartPanelInterface screen;

    public ShoppingCartProcessor(ShoppingCartPanelInterface screen) {
        this.screen = screen;
    }

    @Override
    public void displayShoppingCart(HashMap<String, HashMap<String, Object>> shoppingCartDisplay) {
        screen.displayShoppingCart(shoppingCartDisplay);
    }

    public void setScreen(ShoppingCartPanelInterface screen) {
        this.screen = screen;
    }
}
