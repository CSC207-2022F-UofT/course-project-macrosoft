package user_order_history_use_case;

/**
 * This class is the processor of the user order history.
 */
public class OrderHistoryProcessor implements OrderHistoryPresenter {
    private OrderHistoryPanelInterface orderHistoryPanel;

    /**
     * Constructor for OrderHistoryProcessor
     *
     * @param orderHistoryPanel the order history panel
     */
    public OrderHistoryProcessor(OrderHistoryPanelInterface orderHistoryPanel) {
        this.orderHistoryPanel = orderHistoryPanel;
    }

    /**
     * When the order is found, set order to the order.
     *
     * @param orderHistoryResponseModel response model
     */
    @Override
    public void orderFound(OrderHistoryResponseModel orderHistoryResponseModel) {
        orderHistoryPanel.setOrder(orderHistoryResponseModel);
    }

    /**
     * Order is not found
     */
    @Override
    public void orderNotFound() {

    }

    /**
     * Set the panel to the given panel
     *
     * @param orderHistoryPanel panel
     */
    @Override
    public void setOrderHistoryPanel(OrderHistoryPanelInterface orderHistoryPanel) {
        this.orderHistoryPanel = orderHistoryPanel;
    }
}
