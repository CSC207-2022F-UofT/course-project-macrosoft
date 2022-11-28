package MenuEditingUseCase;

import Database.MenuDataGateway;
import Entities.Menu;
import Interactors.DBConnection;
import Interactors.MongoConnection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import Entities.*;
import java.util.*;

public class AddFoodHelper {

    /**
     *
     * @param curMenu
     * @param name
     * @param description
     * @param category
     * @param price
     */
//    public static Menu add(Restaurant curRes, Menu curMenu, String name, String description, String category, float price, MenuDataGateway dataGateway){
//        Food newFood = new Food(name, description, category, price, new ObjectId());
//        curMenu.addFoodItem(newFood);
//        dataGateway.setMenu(curRes,curMenu);
//        return curMenu;
//    }

    public Menu add(Menu curMenu, String name, String description, String category, float price){
        Food newFood = new Food(name, description, category, price, new ObjectId());
        curMenu.addFoodItem(newFood);
        return curMenu;
    }


}
