package menu_editing_use_case;

// Application Business Rules Layer

import database.MenuDataGateway;
import database.MenuDataMongo;
import database.MongoCollectionFetcher;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import entities.*;

public class MenuEditingInteractor implements AddFoodInputBoundary, RemoveFoodInputBoundary{

    ObjectId resId;

    MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
    MenuDataGateway menuDataGateway = new MenuDataMongo(fetcher);

    public MenuEditingInteractor(ObjectId resId) {
        this.resId = resId;
    }

    /**
     *
     * @param requestModel
     * @return
     */

    @Override
    public void create(AddFoodRequestModel requestModel){
        AddFoodHelper helper = new AddFoodHelper();
        Menu newMenu = helper.add(requestModel.getCurMenu(),
                requestModel.getName(),
                requestModel.getDescription(),
                requestModel.getCategory(),
                requestModel.getPrice());

        menuDataGateway.setMenu(requestModel.getResId(), newMenu);
    };

    @Override
    public void create(RemoveFoodRequestModel requestModel){
        RemoveFoodHelper helper = new RemoveFoodHelper();
        Menu newMenu = helper.remove(requestModel.getCurMenu(), requestModel.getFoodToRemove());

        menuDataGateway.setMenu(requestModel.getResId(), newMenu);

    }

    public Menu getMenu(){
        return menuDataGateway.getMenu(resId);
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

    @Override
    public ObjectId getResId() {
        return resId;
    }

    public void setResId(ObjectId resId) {
        this.resId = resId;
    }
}
