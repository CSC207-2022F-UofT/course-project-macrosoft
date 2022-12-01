package MenuEditingUseCase;

// Application Business Rules Layer

import Entities.Food;
import Entities.Menu;

public class RemoveFoodHelper {

    public Menu remove(Menu curMenu, Food delFood){
        curMenu.removeFoodItem(delFood);
        return curMenu;
    }
}
