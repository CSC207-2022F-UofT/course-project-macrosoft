package update_order_status_use_case;

// Interface Adaptors Layer

/**
 * This interface if the presenter for update order status use case.
 */
public interface UpdateOrderStatusOutputBoundary {

    /**
     * This method prepare success view for the update order status use case.
     */
    void prepareSuccessView();

    /**
     * This method prepare fail view for the update order status use case.
     *
     * @param str String fail message
     */
    void prepareFailView(String str);

    /**
     * This method set screen for the update order status use case.
     *
     * @param screen UpdateOrderStatusScreenInterface current screen
     */
    void setScreen(UpdateOrderStatusScreenInterface screen);
}
