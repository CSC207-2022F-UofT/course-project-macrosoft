package MenuEditingUseCase;
import Entities.*;

public class MenuEditingResponseModel {
    
    private Menu newMenu;

    public MenuEditingResponseModel(Menu newMenu) {
        this.newMenu = newMenu;
    }

    public Menu getNewMenu() {
        return newMenu;
    }

    public void setNewMenu(Menu newMenu) {
        this.newMenu = newMenu;
    }
}
