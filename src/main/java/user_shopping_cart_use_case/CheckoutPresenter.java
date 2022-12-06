package user_shopping_cart_use_case;

public interface CheckoutPresenter {
    void setScreen(ShoppingCartPanelInterface screen);

    void checkoutFailed(String message);
    void checkoutSuccess(String message);
}
