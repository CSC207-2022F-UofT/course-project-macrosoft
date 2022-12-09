package test_update_order_status_use_case;

import database.*;
import entities.Order;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import update_order_status_use_case.*;

import static org.junit.jupiter.api.Assertions.*;

public class UpdateOrderStatusInteractorTest {

    @BeforeEach
    void setUp() {
        Order order = TestFactory.getOrder();
    }

    @Test
    public void testUpdateOrderStatusChange() {
        ObjectId orderId = new ObjectId("63917c69140e363c13186cc5");
        String newStatus = "Order Received";

        UpdateOrderStatusRequestModel request = new UpdateOrderStatusRequestModel(orderId, newStatus);
        UpdateOrderStatusOutputBoundary presenter = new UpdateOrderStatusPresenter(null);
        UpdateOrderStatusInputBoundary interactor = new UpdateOrderStatusInteractor(presenter);
        String expected = "Order Received";
        interactor.updateOrderStatus(request);
        assertEquals(interactor.getOrderStatus(orderId), expected);
    }

    @Test
    public void testUpdateOrderStatusRemainTheSame() {
        ObjectId orderId = new ObjectId("63917c69140e363c13186cc5");
        String newStatus = "Confirming Order";

        UpdateOrderStatusRequestModel request = new UpdateOrderStatusRequestModel(orderId, newStatus);
        UpdateOrderStatusOutputBoundary presenter = new UpdateOrderStatusPresenter(null);
        UpdateOrderStatusInputBoundary interactor = new UpdateOrderStatusInteractor(presenter);
        String expected = "Confirming Order";
        interactor.updateOrderStatus(request);
        String actual = interactor.getOrderStatus(orderId);
        assertEquals(actual, expected);
    }

    @Test
    public void testUpdateOrderStatusSkipMultipleStatus() {
        ObjectId orderId = new ObjectId("63917c69140e363c13186cc5");
        String newStatus = "Ready For Pickup";

        UpdateOrderStatusRequestModel request = new UpdateOrderStatusRequestModel(orderId, newStatus);
        UpdateOrderStatusOutputBoundary presenter = new UpdateOrderStatusPresenter(null);
        UpdateOrderStatusInputBoundary interactor = new UpdateOrderStatusInteractor(presenter);
        String expected = "Ready For Pickup";
        interactor.updateOrderStatus(request);
        assertEquals(interactor.getOrderStatus(orderId), expected);
    }

    // delete the created order from database after the test have been run
    @AfterEach
    void tearDown() {
        ObjectId orderId = new ObjectId("63917c69140e363c13186cc5");
        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
        OrderDataGateway gateway = new OrderDataProcessorMongo(fetcher);
        gateway.deleteByOrderId(orderId);
    }

}
