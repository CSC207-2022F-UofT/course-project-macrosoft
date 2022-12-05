package order_history_use_case;

public class OrderHistoryProcessor implements OrderHistoryPresenter{
    private OrderHistoryPanelInterface orderHistoryPanel;

    public OrderHistoryProcessor(OrderHistoryPanelInterface orderHistoryPanel) {
        this.orderHistoryPanel = orderHistoryPanel;
    }

    @Override
    public void orderFound(OrderHistoryResponseModel orderHistoryResponseModel) {
        orderHistoryPanel.setOrder(orderHistoryResponseModel);
    }

    @Override
    public void orderNotFound() {

    }

    @Override
    public void setOrderHistoryPanel(OrderHistoryPanelInterface orderHistoryPanel) {
        this.orderHistoryPanel = orderHistoryPanel;
    }
}
