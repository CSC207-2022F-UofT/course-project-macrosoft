package update_order_status_use_case;

// Application Business Rules Layer

import entities.*;

/**
 * This class is the response model of the update order status use case.
 */
public class UpdateOrderStatusResponseModel {

    private Order curOrder;

    /**
     * Constructor for UpdateOrderStatusResponseModel
     *
     * @param curOrder Order current order
     */
    public UpdateOrderStatusResponseModel(Order curOrder) {
        this.curOrder = curOrder;
    }

    /**
     * Get current order
     *
     * @return Order current order
     */
    public Order getCurOrder() {
        return this.curOrder;
    }

    /**
     * Set new order as current order
     *
     * @param newOrder Order new order
     */
    public void setCurOrder(Order newOrder) {
        this.curOrder = newOrder;
    }
}
