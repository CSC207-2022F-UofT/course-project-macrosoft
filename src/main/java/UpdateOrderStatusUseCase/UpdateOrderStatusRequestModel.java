package UpdateOrderStatusUseCase;

// Application Business Rule Layer

import Entities.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

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
