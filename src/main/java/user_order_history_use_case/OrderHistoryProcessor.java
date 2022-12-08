package user_order_history_use_case;

public class OrderHistoryProcessor implements OrderHistoryPresenter{
    private OrderHistoryPanelInterface orderHistoryPanel;

    /**
     * A constructor for the order history panel
     *
     * @param orderHistoryPanel The order history panel
     */
    public OrderHistoryProcessor(OrderHistoryPanelInterface orderHistoryPanel) {
        this.orderHistoryPanel = orderHistoryPanel;
    }



    /**
     * Display the orders when the correct orders were found
     *
     * @param orderHistoryResponseModel An instance of order history response model
     */
    @Override
    public void orderFound(OrderHistoryResponseModel orderHistoryResponseModel) {
        orderHistoryPanel.setOrder(orderHistoryResponseModel);
    }



    /**
     * Display when the orders were not correctly found
     */
    @Override
    public void orderNotFound() {

    }



    /**
     * Set the order history panel to the given panel
     *
     * @param orderHistoryPanel An order history panel object
     */
    @Override
    public void setOrderHistoryPanel(OrderHistoryPanelInterface orderHistoryPanel) {
        this.orderHistoryPanel = orderHistoryPanel;
    }
}
