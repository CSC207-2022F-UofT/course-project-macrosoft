package user_shopping_cart_use_case;

import java.util.HashMap;

public interface ShoppingCartPanelInterface {
    void displayShoppingCart(String restaurantName, HashMap<String, HashMap<String, Object>> cart);
    void refreshData();
    void showMessage(String message);
}
