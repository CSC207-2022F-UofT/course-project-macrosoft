package menu_editing_use_case;

// Application Business Rules Layer

import entities.Food;
import entities.Menu;

public class RemoveFoodHelper {

    public Menu remove(Menu curMenu, Food delFood){
        curMenu.removeFoodItem(delFood);
        return curMenu;
    }
}
