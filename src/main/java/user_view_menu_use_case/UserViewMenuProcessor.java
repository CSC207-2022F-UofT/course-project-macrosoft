package user_view_menu_use_case;

public class UserViewMenuProcessor implements UserViewMenuPresenter{

    @Override
    public UserViewMenuResponseModel prepareSuccessView(UserViewMenuResponseModel responseModel){
        return responseModel;

    }

    @Override
    public UserViewMenuResponseModel prepareFailView(UserViewMenuResponseModel responseModel){
        return responseModel;
    }
}
