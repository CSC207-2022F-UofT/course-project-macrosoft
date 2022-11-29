package UpdateOrderStatusUseCase;

// Application Business Rules Layer

import Entities.*;

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
