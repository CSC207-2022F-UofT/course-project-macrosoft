package user_shopping_cart_use_case;

import java.util.HashMap;

public class CheckoutProcessor implements CheckoutPresenter {
    ShoppingCartPanelInterface screen;

    public CheckoutProcessor(ShoppingCartPanelInterface screen) {
        this.screen = screen;
    }

    @Override
    public void checkoutSuccess(String message) {
        screen.showMessage(message);
        ShoppingCartSingleton.setSingletonInstance(new ShoppingCartSingleton(null, new HashMap<>()));
        screen.refreshData();
    }

    @Override
    public void checkoutFailed(String message) {
        screen.showMessage(message);
    }

    public ShoppingCartPanelInterface getScreen() {
        return screen;
    }

    public void setScreen(ShoppingCartPanelInterface screen) {
        this.screen = screen;
    }
}
