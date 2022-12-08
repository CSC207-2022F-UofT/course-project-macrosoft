package user_shopping_cart_use_case;

import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.List;

/**
 * This class is the request model of checkout.
 */
public class CheckoutRequestModel {
    private ObjectId userId;
    private ObjectId restaurantId;
    private HashMap<ObjectId, Integer> cart;

    /**
     * Instantiates a new Checkout request model.
     *
     * @param userId       the user id
     * @param restaurantId the restaurant id
     * @param cart         the cart
     */
    public CheckoutRequestModel(ObjectId userId, ObjectId restaurantId, HashMap<ObjectId, Integer> cart) {
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.cart = cart;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public ObjectId getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    /**
     * Gets restaurant id.
     *
     * @return the restaurant id
     */
    public ObjectId getRestaurantId() {
        return restaurantId;
    }

    /**
     * Sets restaurant id.
     *
     * @param restaurantId the restaurant id
     */
    public void setRestaurantId(ObjectId restaurantId) {
        this.restaurantId = restaurantId;
    }

    /**
     * Gets cart.
     *
     * @return the cart
     */
    public HashMap<ObjectId, Integer> getCart() {
        return cart;
    }

    /**
     * Sets cart.
     *
     * @param cart the cart
     */
    public void setCart(HashMap<ObjectId, Integer> cart) {
        this.cart = cart;
    }
}
