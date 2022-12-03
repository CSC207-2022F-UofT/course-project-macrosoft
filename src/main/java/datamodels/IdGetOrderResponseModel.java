package datamodels;

import entities.Order;

public class IdGetOrderResponseModel {
    private Order order;

    public IdGetOrderResponseModel(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
