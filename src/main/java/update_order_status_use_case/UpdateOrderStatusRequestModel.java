package update_order_status_use_case;

// Application Business Rule Layer

import entities.*;

public class UpdateOrderStatusRequestModel {

    private Order curOrder;
    private String newStatus;

    public UpdateOrderStatusRequestModel(Order curOrder, String newStatus) {
        this.curOrder = curOrder;
        this.newStatus = newStatus;
    }

    public Order getCurOrder() {return curOrder;}

    public String getNewStatus() {return newStatus;}









}
