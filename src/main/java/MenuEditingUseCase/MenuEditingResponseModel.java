package MenuEditingUseCase;

// Application Business Rules Layer

import Entities.*;

import java.util.HashMap;
import java.util.List;

public class MenuEditingResponseModel {
    
//    private Menu newMenu;
    private HashMap<String, List> menuDic;

//    public MenuEditingResponseModel(Menu newMenu) {
//        this.newMenu = newMenu;
//    }

//    public Menu getNewMenu() {
//        return newMenu;
//    }
//
//    public void setNewMenu(Menu newMenu) {
//        this.newMenu = newMenu;
//    }


    public MenuEditingResponseModel(HashMap<String, List> menuDic) {
        this.menuDic = menuDic;
    }

    public HashMap<String, List> getMenuDic() {
        return menuDic;
    }

    public void setMenuDic(HashMap<String, List> menuDic) {
        this.menuDic = menuDic;
    }


}
