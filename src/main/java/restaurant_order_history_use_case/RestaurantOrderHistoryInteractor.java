package restaurant_order_history_use_case;

import database.*;
import entities.Order;
import entities.User;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RestaurantOrderHistoryInteractor implements RestaurantOrderHistoryInputBoundary {
    RestaurantOrderHistoryPresenter presenter;

    public RestaurantOrderHistoryInteractor(RestaurantOrderHistoryPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     *
     */
    @Override
    public void getOrders(ObjectId restaurantId) {
        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        OrderDataGateway orderDataGateway = new OrderDataProcessorMongo(fetcher);
        UserDataGateway userDataGateway = new UserDataProcessorMongo(fetcher);

        List<Order> orders = orderDataGateway.findAllByRestaurant(restaurantId);

        ArrayList<HashMap<String, Object>> orderInfos = new ArrayList<>();

        for (Order order: orders) {
            HashMap<String, Object> orderInfo = new HashMap<>();
            orderInfo.put("ID", order.getOrderID());

            User user = userDataGateway.findById(order.getUserID());
            orderInfo.put("Name", user.getFirstName() + " " + user.getLastName());
            orderInfo.put("Time", order.getOrderDate());
            orderInfo.put("Status", order.getOrderStatus());

            orderInfos.add(orderInfo);
        }

        RestaurantOrderHistoryResponseModel responseModel = new RestaurantOrderHistoryResponseModel(orderInfos);
        presenter.setOrders(responseModel);
    }

    /**
     * @param restaurantId
     */
    @Override
    public void getUnfufilledOrders(ObjectId restaurantId) {
        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        OrderDataGateway orderDataGateway = new OrderDataProcessorMongo(fetcher);
        UserDataGateway userDataGateway = new UserDataProcessorMongo(fetcher);

        List<Order> orders = orderDataGateway.findAllByRestaurant(restaurantId);

        ArrayList<HashMap<String, Object>> orderInfos = new ArrayList<>();

        for (Order order: orders) {
            if (order.getOrderStatus().equals("Order Complete") || order.getOrderStatus().equals("Cancelled")) continue;

            HashMap<String, Object> orderInfo = new HashMap<>();
            orderInfo.put("ID", order.getOrderID());

            User user = userDataGateway.findById(order.getUserID());
            orderInfo.put("Name", user.getFirstName() + " " + user.getLastName());
            orderInfo.put("Time", order.getOrderDate());
            orderInfo.put("Status", order.getOrderStatus());

            orderInfos.add(orderInfo);
        }

        RestaurantOrderHistoryResponseModel responseModel = new RestaurantOrderHistoryResponseModel(orderInfos);
        presenter.setOrders(responseModel);
    }

    public RestaurantOrderHistoryPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(RestaurantOrderHistoryPresenter presenter) {
        this.presenter = presenter;
    }
}
