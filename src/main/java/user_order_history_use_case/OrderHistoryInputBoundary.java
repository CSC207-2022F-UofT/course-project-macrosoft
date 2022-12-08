package user_order_history_use_case;

import org.bson.types.ObjectId;

/**
 * This class is the input boundary for the user get order history use case.
 */
public interface OrderHistoryInputBoundary {

    /**
     * Display all the user order history
     *
     * @param requestModel the request model
     */
    void displayOrders(OrderHistoryRequestModel requestModel);


    /**
     * display all user ongoing orders
     *
     * @param requestModel the request model
     */
    void displayCurrentOrders(OrderHistoryRequestModel requestModel);

}
