package OrderHistoryUseCase;

import DataModels.UserGetOrderRequestModel;
import DataModels.UserGetOrderResponseModel;
import Entities.Order;
import Entities.User;
import InputBoundary.UserGetOrderInputBoundary;
import Interactors.DBConnection;
import Interactors.DocumentOrderConverter;
import Interactors.MongoConnection;
import LoginUseCase.UserInfoAccessor;
import LoginUseCase.UserLoginPresenter;
import LoginUseCase.UserLoginResponseModel;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class OrderHistoryInteractor implements OrderHistoryInputBoundary {


    private OrderHistoryPresenter presenter;
    public OrderHistoryInteractor(OrderHistoryPresenter presenter) {
        this.presenter = presenter;
    }
    public OrderHistoryResponseModel getOrders(OrderHistoryRequestModel requestModel) {

        DBConnection dbConnection = new MongoConnection();

        Bson queryFilter = Filters.eq("userID", requestModel.getUserId());

        ArrayList<Order> orders = new ArrayList<Order>();

        dbConnection.getCollection("Orders")
                .find(queryFilter)
                .map(doc -> DocumentOrderConverter.convertDocumentToOrder((Document) doc))
                .forEach(order -> orders.add((Order) order));

        if (orders.size()>=1) {
            return presenter.getSuccess(new OrderHistoryResponseModel(1000, orders));
        } else {
            return presenter.getFail(new OrderHistoryResponseModel(1001, orders));
        }
    }
}
