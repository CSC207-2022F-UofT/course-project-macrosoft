package MenuEditingUseCase;
import Entities.*;

public class RemoveFoodRequestModel {

    private Menu curMenu;

    private Food foodToRemove;

    public RemoveFoodRequestModel(Menu curMenu, Food foodToRemove) {
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

    public void setFoodToRemove(Food foodToRemove) {
        this.foodToRemove = foodToRemove;
    }
}
