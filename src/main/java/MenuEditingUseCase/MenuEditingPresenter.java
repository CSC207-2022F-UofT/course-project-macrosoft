package MenuEditingUseCase;

//Interface Adapters Layer;


public interface MenuEditingPresenter {

    MenuEditingResponseModel prepareSuccessView(MenuEditingResponseModel responseModel);

    MenuEditingResponseModel prepareFailView(String str);
}
