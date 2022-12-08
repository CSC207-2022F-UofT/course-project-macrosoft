package user_shopping_cart_use_case;

import java.util.HashMap;

public class ShoppingCartProcessor implements ShoppingCartPresenter {

    ShoppingCartPanelInterface screen;

    public ShoppingCartProcessor(ShoppingCartPanelInterface screen) {
        this.screen = screen;
    }

    /**
     * display the shopping cart screen with given information
     * @param restaurantName name of the current restaurant
     * @param shoppingCartDisplay items in the shopping cart
     */
    @Override
    public void displayShoppingCart(String restaurantName, HashMap<String, HashMap<String, Object>> shoppingCartDisplay) {
        screen.displayShoppingCart(restaurantName, shoppingCartDisplay);
    }

    /**
     * set the screen to the given screen
     * @param screen new screen
     */
    public void setScreen(ShoppingCartPanelInterface screen) {
        this.screen = screen;
    }
}
