package MenuEditingUseCase;

import Database.MenuDataGateway;
import Entities.*;

public class MenuEditingInteractor implements AddFoodInputBoundary, RemoveFoodInputBoundary{

    final MenuEditingPresenter menuPresenter;
    final MenuDataGateway menuDataGateway;

    Restaurant curRes;

    public MenuEditingInteractor(MenuEditingPresenter menuPresenter, MenuDataGateway menuDataGateway, Restaurant curRes) {
        this.menuPresenter = menuPresenter;
        this.menuDataGateway = menuDataGateway;
        this.curRes = curRes;
    }

    @Override
    public MenuEditingResponseModel create(AddFoodRequestModel requestModel){
        AddFoodHelper helper = new AddFoodHelper();
        Menu newMenu = helper.add(requestModel.getCurMenu(),
                requestModel.getName(),
                requestModel.getDescription(),
                requestModel.getCategory(),
                requestModel.getPrice());
        MenuEditingResponseModel responseModel = new MenuEditingResponseModel(newMenu);
        menuDataGateway.setMenu(requestModel.getCurRes(), newMenu);
        return menuPresenter.prepareSuccessView(responseModel);
    };

    @Override
    public MenuEditingResponseModel create(RemoveFoodRequestModel requestModel){
        RemoveFoodHelper helper = new RemoveFoodHelper();
        Menu newMenu = helper.remove(requestModel.getCurMenu(), requestModel.getFoodToRemove());
        MenuEditingResponseModel responseModel = new MenuEditingResponseModel(newMenu);
        menuDataGateway.setMenu(requestModel.getCurRes(), newMenu);
        return menuPresenter.prepareSuccessView(responseModel);
    }

    public Menu getMenu(Restaurant curRes){
        return menuDataGateway.getMenu(curRes);
    }
}
