package orderhistoryusecase;

import database.*;
import entities.User;
import loginusecase.LoginUserInteractor;

public class Main {
    public static void main (String[] args){
        LoginUserInteractor i = new LoginUserInteractor();
        i.login("davidlin123", "123456");
        User curUser = LoginUserInteractor.getCurUser();

        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
        OrderHistoryPresenter presenter = new OrderHistoryProcessor();
        OrderDataGateway orderDataGateway = new OrderDataProcessorMongo(fetcher);
        OrderHistoryInputBoundary orderHistoryInputBoundary = new OrderHistoryInteractor(presenter, orderDataGateway, curUser);
        OrderHistoryController controller = new OrderHistoryController(orderHistoryInputBoundary);

        OrderHistoryScreen Screen = new OrderHistoryScreen(controller);
    }
}
