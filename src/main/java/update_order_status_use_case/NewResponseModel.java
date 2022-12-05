package update_order_status_use_case;

import entities.Order;

import java.util.List;

public class NewResponseModel {

    private List<Order> orders;

    private String name;

    public NewResponseModel(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public String getName() {
        return name;
    }
}

