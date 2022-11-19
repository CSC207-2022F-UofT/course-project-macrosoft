package Interactors;

import Entities.*;
import DataModels.*;

import com.mongodb.client.model.Filters;

import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.*;
import java.util.function.Consumer;


public class UserGetOrderInteractor implements UserGetOrderInputBoundary {

    public UserGetOrderResponseModel getOrders(UserGetOrderRequestModel requestModel) {
        DBConnection dbConnection = new MongoConnection();

        Bson queryFilter = Filters.eq("userID", requestModel.getUserId());

        List<Order> orders = new ArrayList<>();

        dbConnection.getCollection("Orders")
                .find(queryFilter)
                .map(doc -> DocumentOrderConverter.convertDocumentToOrder((Document) doc))
                .forEach(order -> orders.add((Order) order));

        UserGetOrderResponseModel responseModel = new UserGetOrderResponseModel(orders);

        return responseModel;
    }
}
