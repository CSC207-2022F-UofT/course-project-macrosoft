package update_order_status_use_case;

// Application Business Rules Layer

import database.MongoCollectionFetcher;
import database.OrderDataGateway;
import database.OrderDataProcessorMongo;
import entities.*;
import org.bson.types.ObjectId;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.text.DateFormat;

public class UpdateOrderStatusInteractor implements UpdateOrderStatusInputBoundary {

    final UpdateOrderStatusPresenter orderPresenter;

    final OrderDataGateway orderDataGateway;

    private Order curOrder;

    private ObjectId orderId;


    private Restaurant curRes;


    public UpdateOrderStatusInteractor(UpdateOrderStatusPresenter orderPresenter, OrderDataGateway orderDataGateway,
                                       Order curOrder) {
        this.orderPresenter = orderPresenter;
        this.orderDataGateway = orderDataGateway;
        this.curOrder = curOrder;
    }

    @Override
    public UpdateOrderStatusResponseModel create(UpdateOrderStatusRequestModel requestModel) {
        return null;
    }

    /**
     *
     * @param requestModel
     * @return
     */

    public void updateOrderStatus(ObjectId orderId, String newStatus) {
        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
        OrderDataGateway orderDataGateway = new OrderDataProcessorMongo(fetcher);

        orderDataGateway.updateOrderStatus(orderId, newStatus);

    }

    public List<Order> getOrders() {
        return orderDataGateway.findAllByRestaurant(curRes.getRestaurantID());
    }

    public Order getCurOrder() {
        return this.curOrder;
    }


    public Restaurant getCurRes() {return curRes;}


    public HashMap<String, List> getOrderDic() {
        HashMap<String, List> orderDic = new HashMap<>();
        List<Order> orderList = this.getOrders();

        List<String> timeList = new ArrayList<>();
        List<String> userIdList = new ArrayList();
        List<String> orderIdList = new ArrayList<>();
        List<List<OrderItem>> itemList = new ArrayList<>();
        List<String> statusList = new ArrayList<>();

        for (Order curOrder: orderList) {

            String pattern = "MM/dd/yyyy HH:mm:ss";
            DateFormat df = new SimpleDateFormat(pattern);
            String strDate = df.format(curOrder.getOrderDate());
            timeList.add(strDate);

            String UserIdCopy = String.valueOf(curOrder.getUserID());
            userIdList.add(UserIdCopy);

            String OrderIdCopy = String.valueOf(curOrder.getOrderID());
            orderIdList.add(OrderIdCopy);


            itemList.add(curOrder.getItems());

            statusList.add(curOrder.getOrderStatus());

            // please check if this for loops works in the way as we wish.
        }

        orderDic.put("time", timeList);
        orderDic.put("userId", userIdList);
        orderDic.put("orderId", orderIdList);
        orderDic.put("items", itemList);
        orderDic.put("order status", statusList);

        return orderDic;
    }
}
