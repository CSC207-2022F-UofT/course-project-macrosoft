package user_shopping_cart_use_case;

import java.util.HashMap;

/**
 * This class is the processor of shopping cart use case.
 */
public class ShoppingCartPresenter implements ShoppingCartOutputBoundary {

    ShoppingCartPanelInterface screen;

    /**
     * Constructor of ShoppingCartPresenter.
     *
     * @param screen the screen
     */
    public ShoppingCartPresenter(ShoppingCartPanelInterface screen) {
        this.screen = screen;
    }

    /**
     * Display the shopping cart screen with given information
     *
     * @param restaurantName      name of the current restaurant
     * @param shoppingCartDisplay items in the shopping cart
     */
    @Override
    public void displayShoppingCart(String restaurantName, HashMap<String, HashMap<String, Object>> shoppingCartDisplay) {
        screen.displayShoppingCart(restaurantName, shoppingCartDisplay);
    }

    /**
     * Sets the screen to the given screen
     *
     * @param screen new screen
     */
    public void setScreen(ShoppingCartPanelInterface screen) {
        this.screen = screen;
    }
}
