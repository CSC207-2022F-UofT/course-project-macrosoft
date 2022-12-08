package user_shopping_cart_use_case;

import java.util.HashMap;

/**
 * This class is the processor of checkout.
 */
public class CheckoutProcessor implements CheckoutPresenter {
    ShoppingCartPanelInterface screen;

    /**
     * Instantiates a new Checkout processor.
     *
     * @param screen the screen
     */
    public CheckoutProcessor(ShoppingCartPanelInterface screen) {
        this.screen = screen;
    }

    /**
     * When checkout success, display a message, create a new instance of the shopping cart singleton
     *
     * @param message result message
     */
    @Override
    public void checkoutSuccess(String message) {
        screen.showMessage(message);
        ShoppingCartSingleton.setSingletonInstance(new ShoppingCartSingleton(null, new HashMap<>()));
        screen.refreshData();
    }

    /**
     * When checkout failed, show a message
     *
     * @param message result message
     */
    @Override
    public void checkoutFailed(String message) {
        screen.showMessage(message);
    }

    /**
     * Gets screen.
     *
     * @return the screen
     */
    public ShoppingCartPanelInterface getScreen() {
        return screen;
    }

    /**
     * Sets screen.
     *
     * @param screen the screen
     */
    public void setScreen(ShoppingCartPanelInterface screen) {
        this.screen = screen;
    }
}
