import class Order;

public class UpdateOrderStatus {

    private Order currentOrder;

    public void UpdateOrderStatus(Order currentOrder, String OrderStatus) {
        currentOrder.setOrderStatus(OrderStatus);
    }

}
