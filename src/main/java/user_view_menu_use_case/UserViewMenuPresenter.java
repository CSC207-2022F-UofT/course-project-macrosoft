package user_view_menu_use_case;

public interface UserViewMenuPresenter {

    UserViewMenuResponseModel prepareSuccessView(UserViewMenuResponseModel responseModel);

    UserViewMenuResponseModel prepareFailView(UserViewMenuResponseModel responseModel);
}
