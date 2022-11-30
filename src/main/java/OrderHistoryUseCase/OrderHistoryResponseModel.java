package OrderHistoryUseCase;

import Entities.Order;

import java.util.List;

public class OrderHistoryResponseModel {
    private List<Order> orders;

    public OrderHistoryResponseModel(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
