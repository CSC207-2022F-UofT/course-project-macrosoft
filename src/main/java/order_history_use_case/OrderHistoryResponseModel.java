package order_history_use_case;

import entities.Order;

import java.util.List;

public class OrderHistoryResponseModel {
    private List<Order> orders;

    public OrderHistoryResponseModel(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
