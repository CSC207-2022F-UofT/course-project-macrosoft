package test_menu_editing_use_case;

import menu_editing_use_case.AddFoodInputBoundary;
import menu_editing_use_case.MenuEditingController;
import menu_editing_use_case.MenuEditingInteractor;
import menu_editing_use_case.RemoveFoodInputBoundary;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import database.*;
import entities.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is the test of menu editing use case.
 */
class MenuEditingTest {

    /**
     * We are only testing part of the methods because the rest are just getters and setters.
     */

    @Test
    public void testEditMenu() {

        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
        MenuDataGateway gateway = new MenuDataMongo(fetcher);
        ObjectId resId = new ObjectId("63797394ee00665db6a0a950");

        AddFoodInputBoundary interactor_add = new MenuEditingInteractor(resId);
        RemoveFoodInputBoundary interactor_remove = new MenuEditingInteractor(resId);
        MenuEditingController controller = new MenuEditingController(interactor_add, interactor_remove, resId);

        controller.add("tiramisu", "goodie goodie", "sweets", 12.00f);
        Menu curMenu = gateway.getMenu(resId);
        Integer list_size = curMenu.getFoodList().size();
        Food curFood = curMenu.getFoodList().get(list_size - 1);
        ObjectId food_id = curFood.getItemID();
        Assertions.assertEquals(curFood.getName(), "tiramisu");

        controller.remove(food_id);
    }

}