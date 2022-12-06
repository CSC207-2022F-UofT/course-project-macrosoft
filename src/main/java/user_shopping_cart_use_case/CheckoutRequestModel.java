package user_shopping_cart_use_case;

import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.List;

public class CheckoutRequestModel {
    private ObjectId userId;
    private ObjectId restaurantId;
    private HashMap<ObjectId, Integer> cart;

    public CheckoutRequestModel(ObjectId userId, ObjectId restaurantId, HashMap<ObjectId, Integer> cart) {
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.cart = cart;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public ObjectId getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(ObjectId restaurantId) {
        this.restaurantId = restaurantId;
    }

    public HashMap<ObjectId, Integer> getCart() {
        return cart;
    }

    public void setCart(HashMap<ObjectId, Integer> cart) {
        this.cart = cart;
    }
}
