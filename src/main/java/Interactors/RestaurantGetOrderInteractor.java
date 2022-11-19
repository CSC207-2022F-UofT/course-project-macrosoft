package Interactors;

import DataModels.RestaurantGetOrderRequestModel;
import DataModels.RestaurantGetOrderResponseModel;
import DataModels.UserGetOrderRequestModel;
import DataModels.UserGetOrderResponseModel;
import Entities.Order;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class RestaurantGetOrderInteractor {
    public RestaurantGetOrderResponseModel getOrders(RestaurantGetOrderRequestModel requestModel) {
        DBConnection dbConnection = new MongoConnection();

        Bson queryFilter = Filters.eq("restaurantID", requestModel.getRestaurantId());

        List<Order> orders = new ArrayList<>();

        dbConnection.getCollection("Orders")
                .find(queryFilter)
                .map(doc -> DocumentOrderConverter.convertDocumentToOrder((Document) doc))
                .forEach(order -> orders.add((Order) order));

        RestaurantGetOrderResponseModel responseModel = new RestaurantGetOrderResponseModel(orders);

        return responseModel;
    }
}
