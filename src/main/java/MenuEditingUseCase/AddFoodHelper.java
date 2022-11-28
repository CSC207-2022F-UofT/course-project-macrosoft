package MenuEditingUseCase;

//Application Business Rule layer

import Entities.Menu;
import org.bson.types.ObjectId;
import Entities.*;

public class AddFoodHelper {

    /** This method adds a Food object to the list of food in the given Menu Object.
     *
     * @param curMenu the current menu to be modifyed.
     * @param name name of the added food.
     * @param description description of the added food.
     * @param category category of the added food.
     * @param price price of the added food.
     * @return returns the new menu with the newly added food.
     */
    public Menu add(Menu curMenu, String name, String description, String category, float price){
        Food newFood = new Food(name, description, category, price, new ObjectId());
        curMenu.addFoodItem(newFood);
        return curMenu;
    }


}
