package user_shopping_cart_use_case;

/*
presenter for the checkout action
 */
public interface CheckoutPresenter {
    void setScreen(ShoppingCartPanelInterface screen);

    void checkoutFailed(String message);
    void checkoutSuccess(String message);
}
