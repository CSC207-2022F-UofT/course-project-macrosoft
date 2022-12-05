package user_view_menu_use_case;

import database.*;
import entities.*;
import user_profile_use_case.UserProfileRequestModel;
import user_profile_use_case.UserProfileResponseModel;

public class DisplayMenuInteractor implements DisplayMenuInputBoundary{

    private DisplayMenuPresenter presenter;

    public DisplayMenuInteractor(DisplayMenuPresenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void displayMenu(DisplayMenuRequestModel requestModel) {
        MongoCollectionFetcher mongoCollectionFetcher = new MongoCollectionFetcher();
        MenuDataGateway menu_gateway = new MenuDataMongo(mongoCollectionFetcher);
        RestaurantDataGateway rest_gateway = new RestaurantDataMongo(mongoCollectionFetcher);

        Menu curMenu = menu_gateway.getMenu(requestModel.getRestId());
        String restName = rest_gateway.getRestaurantNameById(requestModel.getRestId());

        DisplayMenuResponseModel responseModel = new DisplayMenuResponseModel(MenuToDicConverter.getMenuDic(curMenu), restName);
        presenter.presentMenu(responseModel);

    }
}
