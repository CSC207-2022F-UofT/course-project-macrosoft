package Interactors;

import DataModels.IdGetOrderRequestModel;
import DataModels.IdGetOrderResponseModel;
import DataModels.RestaurantGetOrderRequestModel;
import DataModels.RestaurantGetOrderResponseModel;
import Database.MongoCollectionFetcher;
import Database.OrderDataGateway;
import Database.OrderDataProcessorMongo;
import Entities.Order;
import InputBoundary.OrderIdGetOrderInputBoundary;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

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
