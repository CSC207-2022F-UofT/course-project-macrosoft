package create_order_use_case;

import database.MongoCollectionFetcher;
import database.OrderDataGateway;
import database.OrderDataProcessorMongo;
import org.bson.types.ObjectId;

import java.util.Dictionary;

public class CreateOrderInteractor implements CreateOrderInputBoundary{
    public CreateOrderInteractor() {
    }

    @Override
    public void createOrder(Dictionary<ObjectId, Integer> orderList, ObjectId resId, ObjectId userId) {
        MongoCollectionFetcher mongoCollectionFetcher = new MongoCollectionFetcher();
        OrderDataGateway orderDataGateway = new OrderDataProcessorMongo(mongoCollectionFetcher);

        orderDataGateway.create(orderList, resId, userId);
    }
}
