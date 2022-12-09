package user_shopping_cart_use_case;

import org.bson.types.ObjectId;

import java.util.HashMap;


/**
 * This class is a singleton class of shopping cart.
 */
public class ShoppingCartSingleton {
    public static ShoppingCartSingleton singletonInstance = new ShoppingCartSingleton(null, new HashMap<>());
    public HashMap<ObjectId, Integer> cart;
    public ObjectId restaurantId;

    /**
     * Constructor for ShoppingCartSingleton
     *
     * @param restaurantId the restaurant id
     * @param cart         the cart
     */
    public ShoppingCartSingleton(ObjectId restaurantId, HashMap<ObjectId, Integer> cart) {
        this.restaurantId = restaurantId;
        this.cart = cart;
    }

    /**
     * Gets singleton instance.
     *
     * @return the singleton instance
     */
    public static ShoppingCartSingleton getSingletonInstance() {
        return singletonInstance;
    }

    /**
     * Sets singleton instance.
     *
     * @param singletonInstance the singleton instance
     */
    public static void setSingletonInstance(ShoppingCartSingleton singletonInstance) {
        ShoppingCartSingleton.singletonInstance = singletonInstance;
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

    /**
     * Add food item to cart with food id and quantity.
     *
     * @param id       the food id
     * @param quantity the quantity
     */
    public void addFood(ObjectId id, int quantity) {
        cart.put(id, quantity);
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
}
