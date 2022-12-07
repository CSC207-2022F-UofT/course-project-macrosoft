package menu_editing_use_case;

import database.MenuDataGateway;
import database.MenuDataMongo;
import database.MongoCollectionFetcher;
import org.bson.types.ObjectId;
import entities.*;

public class Main {

    public static void main(String[] args) {

        ObjectId resId = new ObjectId("63797394ee00665db6a0a950");
//
//        AddFoodInputBoundary interactor_add = new MenuEditingInteractor(resId);
//        RemoveFoodInputBoundary interactor_remove = new MenuEditingInteractor(resId);
//        MenuEditingController controller = new MenuEditingController(interactor_add, interactor_remove, resId);

//        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
//        MenuDataGateway gateway = new MenuDataMongo(fetcher);
//        Menu curMenu = gateway.getMenu(resId);
//        Food foodToRemove = curMenu.findFood(new ObjectId("638fc76bb234bf7bbfa00314"));

//        controller.remove(new ObjectId("638fc50904aca70a22d15326"));

//        RemoveFoodRequestModel requestModel = new RemoveFoodRequestModel(resId, curMenu, foodToRemove);
//        interactor_remove.create(requestModel);

//
//        System.out.println(curMenu.toString());
//        System.out.println(foodToRemove.getName());
//        RemoveFoodHelper helper = new RemoveFoodHelper();
//        helper.remove(curMenu, foodToRemove);
//        curMenu.removeFoodItem(foodToRemove);
//        System.out.println(curMenu.toString());
//
//        gateway.setMenu(resId,curMenu);



    }
}
