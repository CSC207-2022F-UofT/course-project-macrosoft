package user_order_history_use_case;

import entities.Order;

import java.util.List;

public class OrderHistoryResponseModel {
    private List<Order> orders;

    private String name;

    public OrderHistoryResponseModel(List<Order> orders, String name) {
        this.orders = orders;
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public String getName() {
        return name;
    }
}
