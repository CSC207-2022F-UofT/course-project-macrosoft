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
import user_verify_use_case.GetCodeInteractor;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


public class UpdateOrderStatusInteractorTest {

    // setting up a order that has order id "63335f66bb6cd6599ed6f64d";

    @BeforeEach
    void setUp() {
        Order order = TestFactory.getOrder();
    }

    @Test
    public void testUpdateOrderStatus() {
        ObjectId orderId = new ObjectId("63335f66bb6cd6599ed6f64d");
        String newStatus = "Order Cancelled";

        UpdateOrderStatusRequestModel request = new UpdateOrderStatusRequestModel(orderId, newStatus);
        UpdateOrderStatusPresenter presenter = new UpdateOrderStatusProcessor(null);
        UpdateOrderStatusInteractor interactor = new UpdateOrderStatusInteractor(presenter);
        String expected = "Order Cancelled";
        interactor.updateOrderStatus(request);
        assertEquals(interactor.getOrderStatus(orderId), expected);
    }

     // delete the created order from database after the test have been run
     @AfterEach
     void tearDown() {
         ObjectId orderId = new ObjectId("63335f66bb6cd6599ed6f64d");
         MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
         OrderDataGateway gateway = new OrderDataProcessorMongo(fetcher);
         gateway.delete(gateway.findById(orderId));
     }

}
