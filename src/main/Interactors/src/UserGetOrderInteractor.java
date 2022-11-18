import com.mongodb.client.model.Filters;

import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;


public class UserGetOrderInteractor implements UserGetOrderInputBoundary{

    public UserGetOrderResponseModel getOrders(UserGetOrderRequestModel requestModel) {
        DBConnection dbConnection = new MongoConnection();

        Bson queryFilter = Filters.eq("userID", requestModel.getUserID());

        List<Order> orders = new ArrayList<>();

        dbConnection.getCollection("Orders")
                .find(queryFilter)
                .map(doc -> DocumentOrderConverter.convertDocumentToOrder((Document) doc))
                .forEach((Consumer) order -> orders.add((Order) order));

        UserGetOrderResponseModel responseModel = new UserGetOrderResponseModel(orders);

        return responseModel;
    }
}
