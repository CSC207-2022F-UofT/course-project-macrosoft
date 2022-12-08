package user_shopping_cart_use_case;

import java.util.HashMap;

/**
 * interface of the screen
 */
public interface ShoppingCartPanelInterface {
    /**
     * Display shopping cart.
     *
     * @param restaurantName the restaurant name
     * @param cart           the cart
     */
    void displayShoppingCart(String restaurantName, HashMap<String, HashMap<String, Object>> cart);

    /**
     * Refresh the data.
     */
    void refreshData();

    /**
     * Show message.
     *
     * @param message the message
     */
    void showMessage(String message);
}
