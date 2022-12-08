package user_order_history_use_case;

import org.bson.types.ObjectId;


/**
 * This class is the controller for the user get order history use case.
 */
public class OrderHistoryController {
    private final OrderHistoryInputBoundary orderHistoryInteractor;
    ObjectId currentUserId;

    /**
     * Constructor for UserLoginController
     *
     * @param orderHistoryInteractor       the user order history controller
     * @param currentUserId the current user id
     */
    public OrderHistoryController(OrderHistoryInputBoundary orderHistoryInteractor, ObjectId currentUserId) {
        this.orderHistoryInteractor = orderHistoryInteractor;
        this.currentUserId = currentUserId;
    }


    /**
     * Get all user's order history
     */
    public void getOrders() {
        if(currentUserId == null){
            return;
        }

        OrderHistoryRequestModel requestModel = new OrderHistoryRequestModel(this.getCurrentUserId());

        orderHistoryInteractor.displayOrders(requestModel);
    }


    /**
     * Get user ongoing order
     */
    public void getCurrentOrder() {
        if(currentUserId == null){
            return;
        }

        OrderHistoryRequestModel requestModel = new OrderHistoryRequestModel(this.getCurrentUserId());

        orderHistoryInteractor.displayCurrentOrders(requestModel);
    }

    /**
     * Get the current user id
     */
    public ObjectId getCurrentUserId() {
        return currentUserId;
    }
}
