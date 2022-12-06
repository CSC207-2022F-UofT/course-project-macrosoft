package update_order_status_use_case;

// Application Business Rules Layer

import entities.*;

public class UpdateOrderStatusResponseModel {

    private Order curOrder;

    public UpdateOrderStatusResponseModel(Order curOrder) {
        this.curOrder = curOrder;
    }

    public Order getCurOrder() {
        return curOrder;
    }

    public void setCurOrder(Order newOrder) {
        this.curOrder = curOrder;
    }

}
