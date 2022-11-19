package DataModels;

import Entities.Order;

import java.util.List;

public class IdGetOrderResponseModel {
    private List<Order> orders;

    public IdGetOrderResponseModel(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
