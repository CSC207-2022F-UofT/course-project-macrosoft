package MenuEditingUseCase.Screens;

import MenuEditingUseCase.MenuEditingPresenter;
import MenuEditingUseCase.MenuEditingResponseModel;

public class MenuEditingResponseFormatter implements MenuEditingPresenter {

    @Override
    public MenuEditingResponseModel prepareSuccessView(MenuEditingResponseModel response){
        return response;
    }

    @Override
    public MenuEditingResponseModel prepareFailView(String str) {
        return null;
    }
}
