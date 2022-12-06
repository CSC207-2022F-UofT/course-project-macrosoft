package user_shopping_cart_use_case;

import org.bson.types.ObjectId;

public class ShoppingCartController {
    ShoppingCartInputBoundary shoppingCartInteractor;
    CheckoutInputBoundary checkoutInteractor;

    private ObjectId currentUserId;

    public ShoppingCartController(ShoppingCartInputBoundary shoppingCartInteractor, CheckoutInputBoundary checkoutInteractor, ObjectId currentUserId) {
        this.shoppingCartInteractor = shoppingCartInteractor;
        this.checkoutInteractor = checkoutInteractor;
        this.currentUserId = currentUserId;
    }

    public void displayShoppingCart() {
        shoppingCartInteractor.displayShoppingCart();
    }
    public void deleteItem(ObjectId foodId) {
        ShoppingCartSingleton.getSingletonInstance().getCart().remove(foodId);
    }

    public void checkout() {
        CheckoutRequestModel checkoutRequestModel = new CheckoutRequestModel(currentUserId,
                ShoppingCartSingleton.getSingletonInstance().getRestaurantId(),
                ShoppingCartSingleton.getSingletonInstance().getCart());

        checkoutInteractor.checkout(checkoutRequestModel);
    }

    public ShoppingCartInputBoundary getShoppingCartInteractor() {
        return shoppingCartInteractor;
    }

    public void setShoppingCartInteractor(ShoppingCartInputBoundary shoppingCartInteractor) {
        this.shoppingCartInteractor = shoppingCartInteractor;
    }

    public CheckoutInputBoundary getCheckoutInteractor() {
        return checkoutInteractor;
    }

    public void setCheckoutInteractor(CheckoutInputBoundary checkoutInteractor) {
        this.checkoutInteractor = checkoutInteractor;
    }

    public ObjectId getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(ObjectId currentUserId) {
        this.currentUserId = currentUserId;
    }
}
