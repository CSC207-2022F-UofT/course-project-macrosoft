//package update_order_status_use_case;
//
//import database.MongoCollectionFetcher;
//import database.OrderDataGateway;
//import database.OrderDataProcessorMongo;
//import entities.Order;
//import entities.Restaurant;
//import login_use_case.LoginRestaurantInteractor;
//
//import java.util.List;
//
//public class Main {
//
//    public static void main(String[] args) {
//        LoginRestaurantInteractor i = new LoginRestaurantInteractor();
//        i.login("yinuo's res", "cptbtptp");
//        Restaurant curRes = LoginRestaurantInteractor.getCurrentRestaurant();
//
//        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
//        OrderDataGateway gateway = new OrderDataProcessorMongo(fetcher);
//
//        List<Order> curOrder = gateway.findAllByRestaurant(curRes.getRestaurantID());
//        UpdateOrderStatusPresenter presenter = new UpdateOrderStatusResponseFormatter();
//        UpdateOrderStatusInputBoundary interactor = new UpdateOrderStatusInteractor(presenter, gateway,curOrder.get(0));
//        UpdateOrderStatusController controller = new UpdateOrderStatusController(interactor);
//        UpdateOrderStatusScreen screen = new UpdateOrderStatusScreen(controller);
//
//        }
//
//    }
