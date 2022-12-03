package menueditingusecase;

// Application Business Rules Layer

import database.MenuDataGateway;
import entities.*;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuEditingInteractor implements AddFoodInputBoundary, RemoveFoodInputBoundary{

    final MenuEditingPresenter menuPresenter;
    final MenuDataGateway menuDataGateway;
    Restaurant curRes;

    public MenuEditingInteractor(MenuEditingPresenter menuPresenter, MenuDataGateway menuDataGateway, Restaurant curRes) {
        this.menuPresenter = menuPresenter;
        this.menuDataGateway = menuDataGateway;
        this.curRes = curRes;
    }


    /**
     *
     * @param requestModel
     * @return
     */

    @Override
    public MenuEditingResponseModel create(AddFoodRequestModel requestModel){
        AddFoodHelper helper = new AddFoodHelper();
        Menu newMenu = helper.add(requestModel.getCurMenu(),
                requestModel.getName(),
                requestModel.getDescription(),
                requestModel.getCategory(),
                requestModel.getPrice());
        MenuEditingResponseModel responseModel = new MenuEditingResponseModel(getMenuDic());

        menuDataGateway.setMenu(requestModel.getCurRes(), newMenu);
        return menuPresenter.prepareSuccessView(responseModel);
    };

    @Override
    public MenuEditingResponseModel create(RemoveFoodRequestModel requestModel){
        RemoveFoodHelper helper = new RemoveFoodHelper();
        Menu newMenu = helper.remove(requestModel.getCurMenu(), requestModel.getFoodToRemove());

//        requestModel.getCurMenu().removeFoodItem(requestModel.getFoodToRemove());
        MenuEditingResponseModel responseModel = new MenuEditingResponseModel(getMenuDic());

        menuDataGateway.setMenu(requestModel.getCurRes(), newMenu);
        return menuPresenter.prepareSuccessView(responseModel);
    }

    public Menu getMenu(){
        return menuDataGateway.getMenu(curRes);
    }

    public Restaurant getCurRes() {
        return curRes;
    }

    public HashMap<String, List> getMenuDic(){
        HashMap<String, List> menuDic = new HashMap<>();
        List<Food> foodLst = getMenu().getFoodList();

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
