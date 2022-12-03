package update_order_status_use_case;

//Application Business Rule layer

import entities.*;

import java.util.HashMap;
import java.util.List;

public interface UpdateOrderStatusInputBoundary {

    UpdateOrderStatusResponseModel create(UpdateOrderStatusRequestModel requestModel);

    List<Order> getOrders();

    Order getCurOrder();

    Restaurant getCurRes();

    HashMap<String, List> getOrderDic();






}
