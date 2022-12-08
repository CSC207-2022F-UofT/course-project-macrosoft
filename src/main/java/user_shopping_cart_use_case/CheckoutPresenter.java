package user_shopping_cart_use_case;

/**
 * presenter for the checkout action
 */
public interface CheckoutPresenter {

    /**
     * Sets screen.
     *
     * @param screen the screen
     */
    void setScreen(ShoppingCartPanelInterface screen);

    /**
     * Checkout failed.
     *
     * @param message the message
     */
    void checkoutFailed(String message);

    /**
     * Checkout successful.
     *
     * @param message the message
     */
    void checkoutSuccess(String message);
}
