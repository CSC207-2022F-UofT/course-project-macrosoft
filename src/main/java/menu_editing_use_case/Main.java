package menu_editing_use_case;

import database.MenuDataGateway;
import database.MenuDataMongo;
import database.MongoCollectionFetcher;
import entities.Restaurant;
import login_use_case.LoginRestaurantInteractor;
import menu_editing_use_case.Screens.MenuEditingResponseFormatter;
import menu_editing_use_case.Screens.MenuScreen;

public class Main {

    public static void main(String[] args) {

        LoginRestaurantInteractor i = new LoginRestaurantInteractor();
        i.login("yinuo's res", "cptbtptp");
        Restaurant curRes = LoginRestaurantInteractor.getCurrentRestaurant();

        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
        MenuDataGateway gateway = new MenuDataMongo(fetcher);
        MenuEditingPresenter presenter = new MenuEditingResponseFormatter();
        AddFoodInputBoundary interactor_add = new MenuEditingInteractor(presenter,gateway, curRes);
        RemoveFoodInputBoundary interactor_remove = new MenuEditingInteractor(presenter,gateway, curRes);
        MenuEditingController controller = new MenuEditingController(interactor_add, interactor_remove);

        MenuScreen Screen = new MenuScreen(controller, presenter);

    }
}
