package res_display_menu_usecase;

import database.*;
import entities.Menu;

/**
 * This class is the interactor for the display menu use case.
 */
public class ResDisplayMenuInteractor implements ResDisplayMenuInputBoundary {

    private final ResDisplayMenuOutputBoundary presenter;

    /**
     * Constructor for ResDisplayMenuInteractor
     *
     * @param presenter the presenter
     */
    public ResDisplayMenuInteractor(ResDisplayMenuOutputBoundary presenter) {
        this.presenter = presenter;
    }

    /**
     * Displays the menu.
     *
     * @param requestModel the request model
     */
    @Override
    public void displayMenu(ResDisplayMenuRequestModel requestModel) {
        MongoCollectionFetcher mongoCollectionFetcher = MongoCollectionFetcher.getFetcher();
        MenuDataGateway menu_gateway = new MenuDataMongo(mongoCollectionFetcher);
        RestaurantDataGateway rest_gateway = new RestaurantDataMongo(mongoCollectionFetcher);

        Menu curMenu = menu_gateway.getMenu(requestModel.getRestId());
        String restName = rest_gateway.getRestaurantNameById(requestModel.getRestId());

        ResDisplayMenuResponseModel responseModel = new ResDisplayMenuResponseModel(ResMenuToDicConverter.getMenuDic(curMenu), restName);
        presenter.presentMenu(responseModel);
    }
}
