package user_shopping_cart_use_case;

import java.util.HashMap;

public interface ShoppingCartPanelInterface {
    void displayShoppingCart(HashMap<String, HashMap<String, Object>> cart);
    void refreshData();
}
