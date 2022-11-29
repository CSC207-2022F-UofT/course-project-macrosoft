package UpdateOrderStatusUseCase;

//Application Business Rule layer

import Entities.*;

import java.util.HashMap;
import java.util.List;

public interface UpdateOrderStatusInputBoundary {

    UpdateOrderStatusResponseModel create(UpdateOrderStatusRequestModel requestModel);

    List<Order> getOrders();

    Order getCurOrder();

    Restaurant getCurRes();

    HashMap<String, List> getOrderDic();






}
