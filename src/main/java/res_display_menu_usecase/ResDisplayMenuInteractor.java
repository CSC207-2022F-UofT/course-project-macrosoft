package res_display_menu_usecase;

import database.*;
import entities.Menu;

public class ResDisplayMenuInteractor implements ResDisplayMenuInputBoundary {

    private ResDisplayMenuPresenter presenter;

    public ResDisplayMenuInteractor(ResDisplayMenuPresenter presenter) {
        this.presenter = presenter;
    }

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
