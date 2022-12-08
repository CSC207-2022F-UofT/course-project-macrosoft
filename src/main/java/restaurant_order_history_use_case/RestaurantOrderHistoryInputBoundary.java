package restaurant_order_history_use_case;

import org.bson.types.ObjectId;

/**
 * This class is the input boundary for the restaurant order history use case.
 */
public interface RestaurantOrderHistoryInputBoundary {
    /**
     * Gets the orders for the current restaurant.
     *
     * @param restaurantId the current restaurant id
     */
    void getOrders(ObjectId restaurantId);

    /**
     * Gets the fulfilled orders for the current restaurant.
     *
     * @param restaurantId the current restaurant id
     */
    void getUnfufilledOrders(ObjectId restaurantId);
}
