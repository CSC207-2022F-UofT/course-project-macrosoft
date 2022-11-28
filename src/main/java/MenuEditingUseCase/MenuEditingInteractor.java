package MenuEditingUseCase;

import Entities.*;

public class MenuEditingInteractor implements AddFoodInputBoundary, RemoveFoodInputBoundary{

    final MenuEditingPresenter menuPresenter;

    public MenuEditingInteractor(MenuEditingPresenter menuPresenter) {
        this.menuPresenter = menuPresenter;
    }

    @Override
    public MenuEditingResponseModel create(AddFoodRequestModel requestModel){
        Menu newMenu = AddFoodHelper.add(requestModel.getCurMenu(),
                requestModel.getName(),
                requestModel.getDescription(),
                requestModel.getCategory(),
                requestModel.getPrice());
        MenuEditingResponseModel responseModel = new MenuEditingResponseModel(newMenu);
        return menuPresenter.prepareSuccessView(responseModel);
    };

    @Override
    public MenuEditingResponseModel create(RemoveFoodRequestModel requestModel){
        Menu newMenu = RemoveFoodHelper.remove(requestModel.getCurMenu(), requestModel.getFoodToRemove());
        MenuEditingResponseModel responseModel = new MenuEditingResponseModel(newMenu);
        return menuPresenter.prepareSuccessView(responseModel);
    }
}
