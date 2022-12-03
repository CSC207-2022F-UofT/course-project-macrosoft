package update_order_status_use_case;

// Application Business Rules Layer

import entities.*;

public class UpdateOrderStatusResponseModel {

    private Order newOrder;

    public UpdateOrderStatusResponseModel(Order newOrder) {
        this.newOrder = newOrder;
    }

    public Order getCurOrder() {
        return newOrder;
    }

    public void setNewOrder(Order newOrder) {
        this.newOrder = newOrder;
    }

}
