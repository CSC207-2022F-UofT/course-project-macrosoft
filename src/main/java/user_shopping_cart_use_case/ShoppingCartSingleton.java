package user_shopping_cart_use_case;

import org.bson.types.ObjectId;

import java.util.HashMap;

public class ShoppingCartSingleton {
    public static ShoppingCartSingleton singletonInstance;
    public static HashMap<ObjectId, Integer> cart;

    public ShoppingCartSingleton(HashMap<ObjectId, Integer> cart) {
        this.cart = cart;
    }

    public static ShoppingCartSingleton getSingletonInstance() {
        return singletonInstance;
    }

    public static void setSingletonInstance(ShoppingCartSingleton singletonInstance) {
        ShoppingCartSingleton.singletonInstance = singletonInstance;
    }

    public HashMap<ObjectId, Integer> getCart() {
        return cart;
    }

    public void setCart(HashMap<ObjectId, Integer> cart) {
        this.cart = cart;
    }

    public static void addFood(ObjectId id, int quantity){
        cart.put(id, quantity);
    }
}
