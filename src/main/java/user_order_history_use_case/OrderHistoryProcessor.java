package user_order_history_use_case;

public class OrderHistoryProcessor implements OrderHistoryPresenter{
    private OrderHistoryPanelInterface orderHistoryPanel;

    public OrderHistoryProcessor(OrderHistoryPanelInterface orderHistoryPanel) {
        this.orderHistoryPanel = orderHistoryPanel;
    }

    /**
     * when the order is found, set order to the order.
     * @param orderHistoryResponseModel response model
     */
    @Override
    public void orderFound(OrderHistoryResponseModel orderHistoryResponseModel) {
        orderHistoryPanel.setOrder(orderHistoryResponseModel);
    }

    /**
     * when the order is not found
     */
    @Override
    public void orderNotFound() {

    }

    /**
     * Set the panel to the given panel
     * @param orderHistoryPanel panel
     */
    @Override
    public void setOrderHistoryPanel(OrderHistoryPanelInterface orderHistoryPanel) {
        this.orderHistoryPanel = orderHistoryPanel;
    }
}
