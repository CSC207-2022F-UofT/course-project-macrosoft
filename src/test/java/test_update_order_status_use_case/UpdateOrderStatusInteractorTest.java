package test_update_order_status_use_case;

import database.*;
import entities.Food;
import entities.Order;
import entities.OrderItem;
import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import update_order_status_use_case.*;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


public class UpdateOrderStatusInteractorTest {

    // setting up a order that has order id "63335f66bb6cd6599ed6f64d";

    @BeforeEach
    void setUp() {
        Order order = TestFactory.getOrder();
    }

//    @Test
//    void testUpdateOrderStatus() {
//        ObjectId orderId = new ObjectId("63335f66bb6cd6599ed6f64d");
//        String newStatus = new String("Order Cancelled");
//        String actual = new String("Order Received");
//        UpdateOrderStatusRequestModel request = new UpdateOrderStatusRequestModel(orderId, newStatus);
//        UpdateOrderStatusController controller = new UpdateOrderStatusController(interactor, orderId);
//        UpdateOrderStatusScreenInterface screen = new UpdateOrderStatusScreen(controller);
//        UpdateOrderStatusPresenter presenter = new UpdateOrderStatusProcessor(screen);
//        UpdateOrderStatusInteractor interactor = new UpdateOrderStatusInteractor(presenter);
//
//        assertEquals(.cccc.ccccc., actual);
//        // assertTrue(update_order_status_use_case.UpdateOrderStatusInteractor
//
//    }


    // delete the created order from database after the test have been run
    @AfterEach
    void tearDown() {
        ObjectId orderId = new ObjectId("63335f66bb6cd6599ed6f64d");
        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
        OrderDataGateway gateway = new OrderDataProcessorMongo(fetcher);
        gateway.delete(gateway.findById(orderId));
    }
}
