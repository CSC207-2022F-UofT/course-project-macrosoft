package restaurant_order_history_use_case;

import database.*;
import entities.Order;
import entities.OrderItem;
import entities.User;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class is the interactor for the restaurant order history use case.
 */
public class RestaurantOrderHistoryInteractor implements RestaurantOrderHistoryInputBoundary {
    RestaurantOrderHistoryPresenter presenter;

    /**
     * Constructor for RestaurantOrderHistoryInteractor
     *
     * @param presenter RestaurantOrderHistoryPresenter presenter for the restaurant order history use case
     */
    public RestaurantOrderHistoryInteractor(RestaurantOrderHistoryPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Gets the orders for the current restaurant.
     *
     * @param restaurantId the current restaurant id
     */
    @Override
    public void getOrders(ObjectId restaurantId) {
        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        OrderDataGateway orderDataGateway = new OrderDataProcessorMongo(fetcher);
        UserDataGateway userDataGateway = new UserDataProcessorMongo(fetcher);

        List<Order> orders = orderDataGateway.findAllByRestaurant(restaurantId);

        ArrayList<HashMap<String, Object>> orderInfos = new ArrayList<>();

        for (Order order : orders) {
            HashMap<String, Object> orderInfo = new HashMap<>();
            orderInfo.put("ID", order.getOrderID());

            User user = userDataGateway.findById(order.getUserID());
            orderInfo.put("Name", user.getFirstName() + " " + user.getLastName());
            orderInfo.put("Time", order.getOrderDate());
            orderInfo.put("Status", order.getOrderStatus());

            ArrayList<HashMap<String, Object>> foods = new ArrayList<>();

            for (OrderItem food : order.getItems()) {
                HashMap<String, Object> item = new HashMap<>();
                item.put("name", food.getFood().getName());
                item.put("description", food.getFood().getDescription());
                item.put("category", food.getFood().getCategory());
                item.put("count", food.getNumberOfItem());
                item.put("price", food.getPrice());

                foods.add(item);
            }

            orderInfo.put("OrderItems", foods);

            orderInfos.add(orderInfo);
        }

        RestaurantOrderHistoryResponseModel responseModel = new RestaurantOrderHistoryResponseModel(orderInfos);
        presenter.setOrders(responseModel);
    }

    /**
     * Gets the fulfilled orders for the current restaurant.
     *
     * @param restaurantId the current restaurant id
     */
    @Override
    public void getUnfufilledOrders(ObjectId restaurantId) {
        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        OrderDataGateway orderDataGateway = new OrderDataProcessorMongo(fetcher);
        UserDataGateway userDataGateway = new UserDataProcessorMongo(fetcher);

        List<Order> orders = orderDataGateway.findAllByRestaurant(restaurantId);

        ArrayList<HashMap<String, Object>> orderInfos = new ArrayList<>();

        for (Order order : orders) {
            if (order.getOrderStatus().equals("Order Complete") || order.getOrderStatus().equals("Order Cancelled")) continue;

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
     * Gets the presenter for the restaurant order history use case.
     *
     * @return RestaurantOrderHistoryPresenter presenter for the restaurant order history use case
     */
    public RestaurantOrderHistoryPresenter getPresenter() {
        return presenter;
    }

    /**
     * Sets the presenter for the restaurant order history use case.
     *
     * @param presenter RestaurantOrderHistoryPresenter presenter for the restaurant order history use case
     */
    public void setPresenter(RestaurantOrderHistoryPresenter presenter) {
        this.presenter = presenter;
    }
}
