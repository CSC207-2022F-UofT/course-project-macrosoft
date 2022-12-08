package user_shopping_cart_use_case;

/**
 * This interface is the input boundary of checkout.
 */
public interface CheckoutInputBoundary {
    /**
     * Checkout.
     *
     * @param requestModel the request model
     */
    void checkout(CheckoutRequestModel requestModel);
}
