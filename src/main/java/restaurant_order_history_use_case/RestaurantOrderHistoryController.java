package restaurant_order_history_use_case;

import org.bson.types.ObjectId;

/**
 * This class is the controller for the restaurant order history use case.
 */
public class RestaurantOrderHistoryController {
    private RestaurantOrderHistoryInputBoundary interactor;
    private final ObjectId currentRestaurantId;

    /**
     * Constructor for RestaurantOrderHistoryController
     *
     * @param currentRestaurantId the current restaurant id
     */
    public RestaurantOrderHistoryController(RestaurantOrderHistoryInputBoundary interactor, ObjectId currentRestaurantId) {
        this.interactor = interactor;
        this.currentRestaurantId = currentRestaurantId;
    }

    /**
     * Gets the orders for the current restaurant.
     */
    public void getOrders() {
        interactor.getOrders(currentRestaurantId);
    }

    /**
     * Gets the fulfilled orders for the current restaurant.
     */
    public void getUnfufilledOrders() {
        interactor.getUnfufilledOrders(currentRestaurantId);
    }

    /**
     * Gets the intercator for the current restaurant.
     * @return the interactor
     */
    public RestaurantOrderHistoryInputBoundary getInteractor() {
        return interactor;
    }

    /**
     * Sets the interactor for the current restaurant.
     * @param interactor the interactor
     */
    public void setInteractor(RestaurantOrderHistoryInputBoundary interactor) {
        this.interactor = interactor;
    }
}
