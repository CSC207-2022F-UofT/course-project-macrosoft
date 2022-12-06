package menu_editing_use_case;

import org.bson.types.ObjectId;

public class Main {

    public static void main(String[] args) {

//        RestaurantLoginInteractor i = new RestaurantLoginInteractor();
//        i.login("yinuo's res", "cptbtptp");
//        Restaurant curRes = RestaurantLoginInteractor.getCurrentRestaurant();
        ObjectId resId = new ObjectId("63797394ee00665db6a0a950");

        AddFoodInputBoundary interactor_add = new MenuEditingInteractor(resId);
        RemoveFoodInputBoundary interactor_remove = new MenuEditingInteractor(resId);
        MenuEditingController controller = new MenuEditingController(interactor_add, interactor_remove, resId);
//
//        MenuScreen Screen = new MenuScreen(controller, presenter);


//        Menu curMenu = gateway.getMenu(curRes);
//        Food foodToRemove = curMenu.findFood(new ObjectId("638bc671a577c8726e2e040c"));
//
//        System.out.println(curMenu.toString());
//        System.out.println(foodToRemove.getName());
//        RemoveFoodHelper helper = new RemoveFoodHelper();
//        helper.remove(curMenu, foodToRemove);
////        curMenu.removeFoodItem(foodToRemove);
//        System.out.println(curMenu.toString());
//
//        gateway.setMenu(curRes,curMenu);



    }
}
