package MenuEditingUseCase;

import Entities.Menu;

public interface MenuEditingPresenter {

    MenuEditingResponseModel prepareSuccessView(MenuEditingResponseModel responseModel);

    MenuEditingResponseModel prepareFailView(String str);
}
