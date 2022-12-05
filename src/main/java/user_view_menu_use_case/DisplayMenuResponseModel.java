package user_view_menu_use_case;

import java.util.HashMap;
import java.util.List;

public class DisplayMenuResponseModel {

    private HashMap<String, List> menuDic;

    private String restName;

    public DisplayMenuResponseModel(HashMap<String, List> menuDic, String restName) {
        this.menuDic = menuDic;
        this.restName = restName;
    }

    public HashMap<String, List> getMenuDic() {
        return menuDic;
    }

    public void setMenuDic(HashMap<String, List> menuDic) {
        this.menuDic = menuDic;
    }

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }
}
