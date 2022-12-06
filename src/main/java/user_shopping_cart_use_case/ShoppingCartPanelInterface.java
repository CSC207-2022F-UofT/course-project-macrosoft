package user_shopping_cart_use_case;

import java.util.HashMap;

public interface ShoppingCartPanelInterface {
    void displayShoppingCart(HashMap<String, Integer> cart);
    void refreshData();
}
