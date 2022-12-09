package user_shopping_cart_use_case;

import org.bson.types.ObjectId;

/**
 * This class is the controller of shopping cart use case.
 */
public class ShoppingCartController {
    ShoppingCartInputBoundary shoppingCartInteractor;
    CheckoutInputBoundary checkoutInteractor;

    private final ObjectId currentUserId;

    /**
     * Constructor for ShoppingCartController
     *
     * @param shoppingCartInteractor the shopping cart interactor
     * @param checkoutInteractor     the checkout interactor
     */
    public ShoppingCartController(ShoppingCartInputBoundary shoppingCartInteractor, CheckoutInputBoundary checkoutInteractor, ObjectId currentUserId) {
        this.shoppingCartInteractor = shoppingCartInteractor;
        this.checkoutInteractor = checkoutInteractor;
        this.currentUserId = currentUserId;
    }

    /**
     * Display shopping cart.
     */
    public void displayShoppingCart() {
        shoppingCartInteractor.displayShoppingCart();
    }

    /**
     * Delete food item from shopping cart with food id.
     *
     * @param foodId the food id
     */
    public void deleteItem(ObjectId foodId) {
        ShoppingCartSingleton.getSingletonInstance().getCart().remove(foodId);
    }

    /**
     * Checkout.
     */
    public void checkout() {
        CheckoutRequestModel checkoutRequestModel = new CheckoutRequestModel(currentUserId,
                ShoppingCartSingleton.getSingletonInstance().getRestaurantId(),
                ShoppingCartSingleton.getSingletonInstance().getCart());

        checkoutInteractor.checkout(checkoutRequestModel);
    }
}
