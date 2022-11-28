package MenuEditingUseCase;

import Database.MenuDataGateway;
import Database.MenuDataMongo;
import Database.MongoCollectionFetcher;
import Entities.Restaurant;
import LoginUseCase.LoginRestaurantInteractor;
import MenuEditingUseCase.Screens.MenuEditingResponseFormatter;
import MenuEditingUseCase.Screens.MenuScreen;

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
        MenuEditingController controller = new MenuEditingController(curRes,interactor_add, interactor_remove);

        MenuScreen Screen = new MenuScreen(controller);

    }
}
