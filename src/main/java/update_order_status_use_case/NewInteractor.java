package update_order_status_use_case;

import database.*;
import entities.Order;
import entities.OrderItem;
import entities.Restaurant;
import org.bson.types.ObjectId;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NewInteractor implements NewInputBoundary{

    private final NewPresenter presenter;

    public NewInteractor(NewPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayOrders(NewRequestModel requestModel) {
        MongoCollectionFetcher Fetcher = new MongoCollectionFetcher();

        OrderDataGateway orderDataGateway = new OrderDataProcessorMongo(Fetcher);

        RestaurantDataGateway resDataGateway = new RestaurantDataMongo(Fetcher);

        List<Order> orderList = orderDataGateway.findAllByRestaurant(requestModel.getCurrentResId());

        ObjectId curResId = requestModel.getCurrentResId();

        Restaurant curRestaurant = resDataGateway.findById(curResId);


        if(orderList == null){
            presenter.orderNotFound();
        }
        else {
            NewResponseModel responseModel = new NewResponseModel(orderList);
            presenter.orderFound(responseModel);
        }
    }


    public NewResponseModel getResponse(ObjectId resId){
        MongoCollectionFetcher Fetcher = new MongoCollectionFetcher();
        OrderDataGateway orderDataGateway = new OrderDataProcessorMongo(Fetcher);

        RestaurantDataGateway resDataGateway = new RestaurantDataMongo(Fetcher);

        List<Order> orderList = orderDataGateway.findAllByRestaurant(resId);

        Restaurant curRes = resDataGateway.findById(resId);

        NewResponseModel newResponseModel = new NewResponseModel(orderList);
        return newResponseModel;
    }

    public HashMap<String, List> getOrderDic(ObjectId resId) {
        MongoCollectionFetcher Fetcher = new MongoCollectionFetcher();
        RestaurantDataGateway gateway = new RestaurantDataMongo(Fetcher);
        HashMap<String, List> orderDic = new HashMap<>();
        List<Order> orderList = gateway.getOrderByResId(resId);

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

