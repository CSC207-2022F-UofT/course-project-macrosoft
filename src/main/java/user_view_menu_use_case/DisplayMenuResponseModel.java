package user_view_menu_use_case;

import java.util.HashMap;
import java.util.List;

public class DisplayMenuResponseModel {

    private HashMap<String, List> menuDic;

    private String restName;
    private String restAddress;
    private String restPhone;

    public DisplayMenuResponseModel(HashMap<String, List> menuDic, String restName, String restAddress, String restPhone) {
        this.menuDic = menuDic;
        this.restName = restName;
        this.restAddress = restAddress;
        this.restPhone = restPhone;
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

    public String getRestAddress() {
        return restAddress;
    }

    public void setRestAddress(String restAddress) {
        this.restAddress = restAddress;
    }

    public String getRestPhone() {
        return restPhone;
    }

    public void setRestPhone(String restPhone) {
        this.restPhone = restPhone;
    }
}
