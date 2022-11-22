package DataModels;

import Entities.Order;

import java.util.List;

public class IdGetOrderResponseModel {
    private Order order;

    public IdGetOrderResponseModel(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
