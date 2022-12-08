package user_view_menu_use_case;

import database.*;
import entities.*;

/**
 * This class is the interactor of view menu use case.
 */
public class DisplayMenuInteractor implements DisplayMenuInputBoundary {

    private final DisplayMenuOutputBoundary presenter;

    /**
     * Constructor of DisplayMenuInteractor.
     *
     * @param presenter a display menu presenter
     */
    public DisplayMenuInteractor(DisplayMenuOutputBoundary presenter) {
        this.presenter = presenter;
    }

    /**
     * Display menu.
     *
     * @param requestModel a request model
     */
    @Override
    public void displayMenu(DisplayMenuRequestModel requestModel) {
        MongoCollectionFetcher mongoCollectionFetcher = MongoCollectionFetcher.getFetcher();
        MenuDataGateway menu_gateway = new MenuDataMongo(mongoCollectionFetcher);
        RestaurantDataGateway rest_gateway = new RestaurantDataMongo(mongoCollectionFetcher);

        Menu curMenu = menu_gateway.getMenu(requestModel.getRestId());
        Restaurant rest = rest_gateway.findById(requestModel.getRestId());

        DisplayMenuResponseModel responseModel = new DisplayMenuResponseModel(MenuToDicConverter.getMenuDic(curMenu), rest.getName(), rest.getLocation(), rest.getPhone());
        presenter.presentMenu(responseModel);
    }
}
