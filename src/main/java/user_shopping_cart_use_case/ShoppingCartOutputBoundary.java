package user_shopping_cart_use_case;

import java.util.HashMap;


/**
 * presenter of the shopping cart
 */
public interface ShoppingCartOutputBoundary {
    /**
     * Display shopping cart.
     *
     * @param restaurantName      the restaurant name
     * @param shoppingCartDisplay the shopping cart display
     */
    void displayShoppingCart(String restaurantName, HashMap<String, HashMap<String, Object>> shoppingCartDisplay);

    /**
     * Sets screen.
     *
     * @param screen the screen
     */
    void setScreen(ShoppingCartPanelInterface screen);
}
