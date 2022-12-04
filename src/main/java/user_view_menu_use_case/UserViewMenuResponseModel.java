package user_view_menu_use_case;
import java.util.HashMap;
import java.util.List;

public class UserViewMenuResponseModel {

    private HashMap<String, List> menuDic;

    public UserViewMenuResponseModel(HashMap<String, List> menuDic) {
        this.menuDic = menuDic;
    }

    public HashMap<String, List> getMenuDic() {
        return menuDic;
    }

    public void setMenuDic(HashMap<String, List> menuDic) {
        this.menuDic = menuDic;
    }
}
