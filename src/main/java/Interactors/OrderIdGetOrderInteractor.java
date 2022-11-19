package Interactors;

import DataModels.IdGetOrderRequestModel;
import DataModels.IdGetOrderResponseModel;
import DataModels.RestaurantGetOrderRequestModel;
import DataModels.RestaurantGetOrderResponseModel;
import Entities.Order;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class OrderIdGetOrderInteractor {
    public IdGetOrderResponseModel getOrders(IdGetOrderRequestModel requestModel) {
        DBConnection dbConnection = new MongoConnection();

        Bson queryFilter = Filters.eq("_id", requestModel.getOrderId());

        List<Order> orders = new ArrayList<>();

        dbConnection.getCollection("Orders")
                .find(queryFilter)
                .map(doc -> DocumentOrderConverter.convertDocumentToOrder((Document) doc))
                .forEach(order -> orders.add((Order) order));

        IdGetOrderResponseModel responseModel = new IdGetOrderResponseModel(orders);

        return responseModel;
    }
}
