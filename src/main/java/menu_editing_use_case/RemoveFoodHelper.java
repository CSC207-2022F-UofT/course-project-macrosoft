package menu_editing_use_case;

// Application Business Rules Layer

import entities.Menu;
import org.bson.types.ObjectId;

/**
 * This class is the helper class for the remove food use case.
 */
public class RemoveFoodHelper {

    /**
     * This method removes a Food object from the list of food in the given Menu Object.
     *
     * @param curMenu the current menu to be modifyed.
     * @param delFood the id of the food to be removed.
     * @return returns the new menu with the newly removed food.
     */
    public Menu remove(Menu curMenu, ObjectId delFood) {
        curMenu.removeFoodItem(delFood);
        return curMenu;
    }
}
