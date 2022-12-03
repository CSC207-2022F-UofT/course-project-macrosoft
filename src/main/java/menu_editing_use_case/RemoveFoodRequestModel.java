package menu_editing_use_case;

// Application Business Rules Layer

import entities.*;

public class RemoveFoodRequestModel {

    private Restaurant curRes;

    private Menu curMenu;

    private Food foodToRemove;

    public RemoveFoodRequestModel(Restaurant curRes, Menu curMenu, Food foodToRemove) {
        this.curRes = curRes;
        this.curMenu = curMenu;
        this.foodToRemove = foodToRemove;
    }
    public Menu getCurMenu() {
        return curMenu;
    }

    public void setCurMenu(Menu curMenu) {
        this.curMenu = curMenu;
    }

    public Food getFoodToRemove() {
        return foodToRemove;
    }

    public Restaurant getCurRes() {
        return curRes;
    }

    public void setCurRes(Restaurant curRes) {
        this.curRes = curRes;
    }

    public void setFoodToRemove(Food foodToRemove) {
        this.foodToRemove = foodToRemove;
    }
}
