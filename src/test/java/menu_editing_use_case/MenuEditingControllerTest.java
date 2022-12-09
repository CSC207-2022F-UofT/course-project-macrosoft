package menu_editing_use_case;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import database.*;
import entities.*;

import static org.junit.jupiter.api.Assertions.*;

class MenuEditingTest {

    MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
    MenuDataGateway gateway = new MenuDataMongo(fetcher);
    ObjectId resId = new ObjectId("63797394ee00665db6a0a950");

    AddFoodInputBoundary interactor_add = new MenuEditingInteractor(resId);
    RemoveFoodInputBoundary interactor_remove = new MenuEditingInteractor(resId);
    MenuEditingController controller = new MenuEditingController(interactor_add, interactor_remove, resId);

    ObjectId food_id;
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

        controller.remove(food_id);

    }

    /**
     * We are only testing part of the methods because the rest are just getters and setters.
     */

    @Test
    public void testEditMenu() {

        controller.add("tiramisu", "goodie goodie", "sweets", 12.00f);
        Menu curMenu = gateway.getMenu(resId);
        Integer list_size = curMenu.getFoodList().size();
        Food curFood = curMenu.getFoodList().get(list_size-1);
        food_id = curFood.getItemID();
        Assertions.assertEquals(curFood.getName(), "tiramisu");
    }

}