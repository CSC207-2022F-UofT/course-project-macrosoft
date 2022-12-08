package user_order_history_use_case;

import database.*;
import entities.Order;
import entities.OrderItem;
import entities.User;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

// Use case layer
// Single Responsibility: Display orders

/**
 * This class is the interactor of the user order history.
 */
public class OrderHistoryInteractor implements OrderHistoryInputBoundary {

    private final OrderHistoryPresenter presenter;

    /**
     * Constructor for OrderHistoryInteractor
     *
     * @param presenter the presenter
     */
    public OrderHistoryInteractor(OrderHistoryPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Display orders.
     *
     * @param requestModel the request model
     */
    @Override
    public void displayOrders(OrderHistoryRequestModel requestModel) {
        MongoCollectionFetcher mongoCollectionFetcher = MongoCollectionFetcher.getFetcher();
        OrderDataGateway orderDataGateway = new OrderDataProcessorMongo(mongoCollectionFetcher);
        UserDataGateway userDataGateway = new UserDataProcessorMongo(mongoCollectionFetcher);
        RestaurantDataGateway restaurantDataGateway = new RestaurantDataMongo(mongoCollectionFetcher);

        List<Order> orderList = orderDataGateway.findAllByUser(requestModel.getCurrentUserId());

        ObjectId curUserId = requestModel.getCurrentUserId();
        User curUser = userDataGateway.findById(curUserId);
        String name = curUser.getFirstName() + " " + curUser.getLastName();


        if (orderList == null) {
            presenter.orderNotFound();
        } else {
            ArrayList<HashMap<String, Object>> result = new ArrayList<>();

            for (Order order : orderList) {
                HashMap<String, Object> info = new HashMap<>();
                restaurantDataGateway.getRestaurantNameById(order.getRestaurantID());

                info.put("restaurantName", restaurantDataGateway.getRestaurantNameById(order.getRestaurantID()));
                info.put("orderTime", order.getOrderDate());
                info.put("orderStatus", order.getOrderStatus());
                info.put("orderId", order.getOrderID());

                ArrayList<HashMap<String, Object>> foods = new ArrayList<>();

                for (OrderItem food : order.getItems()) {
                    HashMap<String, Object> item = new HashMap<>();
                    item.put("name", food.getFood().getName());
                    item.put("description", food.getFood().getDescription());
                    item.put("category", food.getFood().getCategory());
                    item.put("count", food.getNumberOfItem());
                    item.put("price", food.getFood().getPrice());

                    foods.add(item);
                }

                info.put("orderItems", foods);

                result.add(info);
            }

            OrderHistoryResponseModel responseModel = new OrderHistoryResponseModel(result, name);
            presenter.orderFound(responseModel);
        }
    }

    /**
     * Display current orders.
     *
     * @param requestModel the request model
     */
    public void displayCurrentOrders(OrderHistoryRequestModel requestModel) {
        MongoCollectionFetcher mongoCollectionFetcher = MongoCollectionFetcher.getFetcher();
        OrderDataGateway orderDataGateway = new OrderDataProcessorMongo(mongoCollectionFetcher);
        UserDataGateway userDataGateway = new UserDataProcessorMongo(mongoCollectionFetcher);
        RestaurantDataGateway restaurantDataGateway = new RestaurantDataMongo(mongoCollectionFetcher);

        List<Order> orderList = orderDataGateway.findAllByUser(requestModel.getCurrentUserId());

        ObjectId curUserId = requestModel.getCurrentUserId();
        User curUser = userDataGateway.findById(curUserId);
        String name = curUser.getFirstName() + " " + curUser.getLastName();


        if (orderList == null) {
            presenter.orderNotFound();
        } else {
            orderList = orderList
                    .stream()
                    .filter(order -> (!order.getOrderStatus().equals("Order Complete") && !order.getOrderStatus().equals("Order Cancelled")))
                    .collect(Collectors.toList());

            ArrayList<HashMap<String, Object>> result = new ArrayList<>();

            for (Order order : orderList) {
                HashMap<String, Object> info = new HashMap<>();
                restaurantDataGateway.getRestaurantNameById(order.getRestaurantID());

                info.put("restaurantName", restaurantDataGateway.getRestaurantNameById(order.getRestaurantID()));
                info.put("orderTime", order.getOrderDate());
                info.put("orderStatus", order.getOrderStatus());
                info.put("orderId", order.getOrderID());

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

                info.put("orderItems", foods);

                result.add(info);
            }

            OrderHistoryResponseModel responseModel = new OrderHistoryResponseModel(result, name);
            presenter.orderFound(responseModel);
        }
    }
}
