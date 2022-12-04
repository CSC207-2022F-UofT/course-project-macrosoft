package user_view_menu_use_case;

import database.MenuDataGateway;
import menu_editing_use_case.MenuEditingPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import entities.*;
import org.bson.types.ObjectId;

public class UserViewMenuInteractor implements UserViewMenuInputBoundary{

    final UserViewMenuPresenter presenter;

    final MenuDataGateway menuDataGateway;

    public UserViewMenuInteractor(UserViewMenuPresenter presenter, MenuDataGateway menuDataGateway) {
        this.presenter = presenter;
        this.menuDataGateway = menuDataGateway;
    }

    public UserViewMenuResponseModel create(UserViewMenuRequestModel requestModel){
        HashMap<String, List> menuDic =  getMenuDic(requestModel.getResId());
        UserViewMenuResponseModel responseModel = new UserViewMenuResponseModel(menuDic);
        return presenter.prepareSuccessView(responseModel);
    }

    public HashMap<String, List> getMenuDic(ObjectId restId){
        Menu curMenu = menuDataGateway.getMenu(restId);
        HashMap<String, List> menuDic = new HashMap<>();

        List<Food> foodLst = curMenu.getFoodList();

        List<String> nameList = new ArrayList<>();
        List<String> descriptionList = new ArrayList<>();
        List<String> categoryList = new ArrayList<>();
        List<Float> priceList = new ArrayList<>();
        List<ObjectId> idList = new ArrayList<>();

        for(Food curFood: foodLst){
            nameList.add(curFood.getName());
            descriptionList.add(curFood.getDescription());
            categoryList.add(curFood.getCategory());
            priceList.add(curFood.getPrice());
            idList.add(curFood.getItemID());
        }

        menuDic.put("name", nameList);
        menuDic.put("description", descriptionList);
        menuDic.put("category", categoryList);
        menuDic.put("price", priceList);
        menuDic.put("id", idList);

        return menuDic;
    }
}
