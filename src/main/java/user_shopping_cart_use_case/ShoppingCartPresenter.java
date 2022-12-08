package user_shopping_cart_use_case;

/*
presenter of the shopping cart
 */
import java.util.HashMap;

public interface ShoppingCartPresenter {
    void displayShoppingCart(String restaurantName, HashMap<String, HashMap<String, Object>> shoppingCartDisplay);
    void setScreen(ShoppingCartPanelInterface screen);
}
