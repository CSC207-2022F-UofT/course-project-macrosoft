package user_order_history_use_case;

/**
 * This interface is the input boundary of the user order history.
 */
public interface OrderHistoryInputBoundary {
    /**
     * Display orders.
     *
     * @param requestModel the request model
     */
    void displayOrders(OrderHistoryRequestModel requestModel);

    /**
     * Display current orders.
     *
     * @param requestModel the request model
     */
    void displayCurrentOrders(OrderHistoryRequestModel requestModel);

}
