package test_shopping_cart_use_case;

import database.MongoCollectionFetcher;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import user_shopping_cart_use_case.*;

import java.util.HashMap;

public class ShoppingCartInteractorTest {
    @BeforeEach
    void setUp() {
        HashMap<ObjectId, Integer> cart = new HashMap<>();
        cart.put(new ObjectId("638bc2c46385b813a6a98a02"), 1);
        ShoppingCartSingleton.setSingletonInstance(new ShoppingCartSingleton(new ObjectId("63797394ee00665db6a0a950"), cart));
    }

    @Test
    void testDisplayShoppingCart() {
        try {
            ShoppingCartPresenter presenter = new ShoppingCartPresenter(null);
            ShoppingCartInputBoundary interactor = new ShoppingCartInteractor(presenter);
            ShoppingCartController controller = new ShoppingCartController(interactor, null, new ObjectId("63335e7abb6cd6599ed6f64b"));
            ShoppingCartPanelInterface screen = new ShoppingCartPanel(controller);
            presenter.setScreen(screen);

            controller.displayShoppingCart();
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }
}
