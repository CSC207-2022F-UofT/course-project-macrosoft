package user_view_menu_use_case;

import org.bson.types.ObjectId;

public class UserViewMenuController {

    final UserViewMenuInputBoundary interactor;

    public UserViewMenuController(UserViewMenuInputBoundary interactor) {
        this.interactor = interactor;
    }

    public UserViewMenuResponseModel create(ObjectId resId){
        UserViewMenuRequestModel requestModel = new UserViewMenuRequestModel(resId);
        return interactor.create(requestModel);
    }

}
