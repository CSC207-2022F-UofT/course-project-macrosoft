package menu_editing_use_case;

// Application Business Rules Layer

import entities.Food;
import entities.Menu;
import org.bson.types.ObjectId;

public class RemoveFoodHelper {

    public Menu remove(Menu curMenu, ObjectId delFood){
        curMenu.removeFoodItem(delFood);
        return curMenu;
    }
}
