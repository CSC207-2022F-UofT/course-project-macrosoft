package order_history_use_case;

import database.*;
import entities.Order;
import entities.User;
import org.bson.types.ObjectId;

import java.util.List;

public class OrderHistoryInteractor implements OrderHistoryInputBoundary{

    private final OrderHistoryPresenter presenter;

    public OrderHistoryInteractor(OrderHistoryPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayOrders(OrderHistoryRequestModel requestModel) {
        MongoCollectionFetcher mongoCollectionFetcher = new MongoCollectionFetcher();
        OrderDataGateway orderDataGateway = new OrderDataProcessorMongo(mongoCollectionFetcher);

        UserDataGateway userDataGateway = new UserDataProcessorMongo(mongoCollectionFetcher);

        List<Order> orderList = orderDataGateway.findAllByUser(requestModel.getCurrentUserId());

        ObjectId curUserId = requestModel.getCurrentUserId();

        User curUser = userDataGateway.findById(curUserId);

        String name = curUser.getFirstName() + " " + curUser.getLastName();


        if(orderList == null){
            presenter.orderNotFound();
        }
        else {
            OrderHistoryResponseModel responseModel = new OrderHistoryResponseModel(orderList, name);
            presenter.orderFound(responseModel);
        }
    }

    public OrderHistoryResponseModel getResponse(ObjectId userId){
        MongoCollectionFetcher mongoCollectionFetcher = new MongoCollectionFetcher();
        OrderDataGateway orderDataGateway = new OrderDataProcessorMongo(mongoCollectionFetcher);

        UserDataGateway userDataGateway = new UserDataProcessorMongo(mongoCollectionFetcher);

        List<Order> orderList = orderDataGateway.findAllByUser(userId);

        User curUser = userDataGateway.findById(userId);

        String name = curUser.getFirstName() + " " + curUser.getLastName();

        OrderHistoryResponseModel orderHistoryResponseModel = new OrderHistoryResponseModel(orderList, name);
        return orderHistoryResponseModel;
    }
}
