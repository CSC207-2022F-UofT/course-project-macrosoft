package test_update_order_status_use_case;

import database.MongoCollectionFetcher;
import database.OrderDataGateway;
import database.OrderDataProcessorMongo;
import entities.Order;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import update_order_status_use_case.*;

import static org.junit.jupiter.api.Assertions.*;

public class UpdateOrderStatusRequestModelTest {

    @Test
    public void testGetObjectId() {
        ObjectId orderId = new ObjectId("63335f66bb6cd6599ed6f64d");
        String newStatus = "Order Received";
        UpdateOrderStatusRequestModel presenter = new UpdateOrderStatusRequestModel(orderId, newStatus);
        ObjectId expected = new ObjectId("63335f66bb6cd6599ed6f64d");
        assertEquals(expected, presenter.getCurOrderId());
    }

    @Test
    public void testGetNewStatusNotEmpty() {
        ObjectId orderId = new ObjectId("63335f66bb6cd6599ed6f64d");
        String newStatus = "Order Received";
        UpdateOrderStatusRequestModel presenter = new UpdateOrderStatusRequestModel(orderId, newStatus);
        String expected = "Order Received";
        assertEquals(expected, presenter.getNewStatus());
    }

    @Test
    public void testGetNewStatus() {
        ObjectId orderId = new ObjectId("63335f66bb6cd6599ed6f64d");
        String newStatus = "";
        UpdateOrderStatusRequestModel presenter = new UpdateOrderStatusRequestModel(orderId, newStatus);
        String expected = "";
        assertEquals(expected, presenter.getNewStatus());
    }

}
