package restaurant_order_history_use_case;

import org.bson.types.ObjectId;

public class RestaurantOrderHistoryController {
    private RestaurantOrderHistoryInputBoundary interactor;
    private ObjectId currentRestaurantId;

    public RestaurantOrderHistoryController(RestaurantOrderHistoryInputBoundary interactor, ObjectId currentRestaurantId) {
        this.interactor = interactor;
        this.currentRestaurantId = currentRestaurantId;
    }

    public void getOrders() {
        interactor.getOrders(currentRestaurantId);
    }

    public void getUnfufilledOrders() {
        interactor.getUnfufilledOrders(currentRestaurantId);
    }

    public RestaurantOrderHistoryInputBoundary getInteractor() {
        return interactor;
    }

    public void setInteractor(RestaurantOrderHistoryInputBoundary interactor) {
        this.interactor = interactor;
    }

    public ObjectId getCurrentRestaurantId() {
        return currentRestaurantId;
    }

    public void setCurrentRestaurantId(ObjectId currentRestaurantId) {
        this.currentRestaurantId = currentRestaurantId;
    }
}
