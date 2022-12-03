package datamodels;

import java.util.List;

import entities.*;

public class UserGetOrderResponseModel {
    private List<Order> orders;

    public UserGetOrderResponseModel(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
