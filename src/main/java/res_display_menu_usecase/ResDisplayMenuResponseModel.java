package res_display_menu_usecase;

import java.util.HashMap;
import java.util.List;

public class ResDisplayMenuResponseModel {

    private HashMap<String, List> menuDic;

    private String restName;

    public ResDisplayMenuResponseModel(HashMap<String, List> menuDic, String restName) {
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
