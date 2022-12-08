package user_order_history_use_case;

import org.bson.types.ObjectId;

/**
 * This class is the controller of the user order history.
 */
public class OrderHistoryController {
    private final OrderHistoryInputBoundary orderHistoryInteractor;
    ObjectId currentUserId;

    /**
     * Constructor for OrderHistoryController
     *
     * @param orderHistoryInteractor the order history interactor
     * @param currentUserId          the current user id
     */
    public OrderHistoryController(OrderHistoryInputBoundary orderHistoryInteractor, ObjectId currentUserId) {
        this.orderHistoryInteractor = orderHistoryInteractor;
        this.currentUserId = currentUserId;
    }

    /**
     * Geta orders.
     */
    public void getOrders() {
        if (currentUserId == null) {
            return;
        }

        OrderHistoryRequestModel requestModel = new OrderHistoryRequestModel(this.getCurrentUserId());

        orderHistoryInteractor.displayOrders(requestModel);
    }

    /**
     * Gets current orders.
     */
    public void getCurrentOrder() {
        if (currentUserId == null) {
            return;
        }

        OrderHistoryRequestModel requestModel = new OrderHistoryRequestModel(this.getCurrentUserId());

        orderHistoryInteractor.displayCurrentOrders(requestModel);
    }

    /**
     * Gets current user id.
     *
     * @return the current user id
     */
    public ObjectId getCurrentUserId() {
        return currentUserId;
    }
}
