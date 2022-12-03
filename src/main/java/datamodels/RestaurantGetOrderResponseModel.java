package datamodels;

import entities.Order;

import java.util.List;

public class RestaurantGetOrderResponseModel {
    private List<Order> orders;

    public RestaurantGetOrderResponseModel(List<Order> orders) { this.orders = orders; }

    public List<Order> getOrders() {
        return orders;
    }
}
