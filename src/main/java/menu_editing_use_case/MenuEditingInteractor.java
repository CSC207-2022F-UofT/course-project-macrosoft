package menu_editing_use_case;

// Application Business Rules Layer

import database.MenuDataGateway;
import database.MenuDataMongo;
import database.MongoCollectionFetcher;
import org.bson.types.ObjectId;

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
     * @param requestModel an instance of AddFoodRequestModel
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
    }

    @Override
    public void create(RemoveFoodRequestModel requestModel){
        RemoveFoodHelper helper = new RemoveFoodHelper();
        Menu newMenu = helper.remove(requestModel.getCurMenu(), requestModel.getFoodToRemove());

        menuDataGateway.setMenu(requestModel.getResId(), newMenu);

    }

    public Menu getMenu(){
        return menuDataGateway.getMenu(resId);
    }

    @Override
    public ObjectId getResId() {
        return resId;
    }

    public void setResId(ObjectId resId) {
        this.resId = resId;
    }
}
