package test_update_order_status_use_case;

import database.MongoCollectionFetcher;
import database.OrderDataGateway;
import database.OrderDataProcessorMongo;
import entities.Food;
import entities.Order;
import entities.OrderItem;
import org.bson.types.ObjectId;
import update_order_status_use_case.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class TestFactory {

    public static Order getOrder() {
        ObjectId orderId = new ObjectId("63335f66bb6cd6599ed6f64d");
        ObjectId restaurantId = new ObjectId("63797394ee00665db6a0a950");
        ObjectId userId = new ObjectId("63335e7abb6cd6599ed6f64b");

        ObjectId foodId = new ObjectId("1");
        Food food = new Food("a","b", "c",12, foodId);
        OrderItem o1 = new OrderItem(foodId, food, 10);
        ArrayList<OrderItem> items = new ArrayList<>();
        items.add(0, o1);

        String orderStatus = new String("Ready For Pickup");
        Date orderDate = new Date();

        Order order = new Order(orderId, orderDate, restaurantId, userId, items, orderStatus);

        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        OrderDataGateway gateway = new OrderDataProcessorMongo(fetcher);
        gateway.save(order);

        return order;
    }


    public static UpdateOrderStatusPresenter getPresenter(){
        UpdateOrderStatusPresenter presenter = new UpdateOrderStatusProcessor(null);

        return presenter;
    }
}
