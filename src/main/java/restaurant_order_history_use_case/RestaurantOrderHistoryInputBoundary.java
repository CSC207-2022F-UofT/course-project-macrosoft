package restaurant_order_history_use_case;

import org.bson.types.ObjectId;

public interface RestaurantOrderHistoryInputBoundary {
    void getOrders(ObjectId restaurantId);
    void getUnfufilledOrders(ObjectId restaurantId);
}
