package interactors;

import datamodels.IdGetOrderRequestModel;
import datamodels.IdGetOrderResponseModel;
import database.MongoCollectionFetcher;
import database.OrderDataGateway;
import database.OrderDataProcessorMongo;
import entities.Order;
import inputboundary.OrderIdGetOrderInputBoundary;
import org.bson.types.ObjectId;

public class OrderIdGetOrderInteractor implements OrderIdGetOrderInputBoundary {
    public IdGetOrderResponseModel getOrder(IdGetOrderRequestModel requestModel) {
        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
        OrderDataGateway orderDataGateway = new OrderDataProcessorMongo(fetcher);

        ObjectId id = new ObjectId(requestModel.getOrderId());

        Order order = orderDataGateway.findById(id);

        IdGetOrderResponseModel responseModel = new IdGetOrderResponseModel(order);

        return responseModel;
    }
}
