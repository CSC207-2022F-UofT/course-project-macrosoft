package menu_editing_use_case;

import database.MenuDataGateway;
import database.MenuDataMongo;
import database.MongoCollectionFetcher;
import entities.Restaurant;
import login_use_case.RestaurantLoginInteractor;
import menu_editing_use_case.Screens.MenuEditingResponseFormatter;
import menu_editing_use_case.Screens.MenuScreen;

public class Main {

    public static void main(String[] args) {

//        RestaurantLoginInteractor i = new RestaurantLoginInteractor();
//        i.login("yinuo's res", "cptbtptp");
//        Restaurant curRes = RestaurantLoginInteractor.getCurrentRestaurant();
//
//        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
//        MenuDataGateway gateway = new MenuDataMongo(fetcher);
//
//        MenuEditingPresenter presenter = new MenuEditingResponseFormatter();
//        AddFoodInputBoundary interactor_add = new MenuEditingInteractor(presenter,gateway, curRes);
//        RemoveFoodInputBoundary interactor_remove = new MenuEditingInteractor(presenter,gateway, curRes);
//        MenuEditingController controller = new MenuEditingController(interactor_add, interactor_remove);
//
//        MenuScreen Screen = new MenuScreen(controller, presenter);


//        Menu curMenu = gateway.getMenu(curRes);
//        Food foodToRemove = curMenu.findFood(new ObjectId("638bc671a577c8726e2e040c"));
//
//        System.out.println(curMenu.toString());
//        System.out.println(foodToRemove.getName());
//        RemoveFoodHelper helper = new RemoveFoodHelper();
//        helper.remove(curMenu, foodToRemove);
////        curMenu.removeFoodItem(foodToRemove);
//        System.out.println(curMenu.toString());
//
//        gateway.setMenu(curRes,curMenu);



    }
}
