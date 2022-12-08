package res_display_menu_usecase;

import java.util.HashMap;
import java.util.List;

/**
 * This class is the response model for the display menu use case.
 */
public class ResDisplayMenuResponseModel {

    private final HashMap<String, List> menuDic;

    private final String restName;

    /**
     * Constructor for ResDisplayMenuResponseModel
     *
     * @param menuDic the menu dictionary
     * @param restName the rest name
     */
    public ResDisplayMenuResponseModel(HashMap<String, List> menuDic, String restName) {
        this.menuDic = menuDic;
        this.restName = restName;
    }

    /**
     * Gets the menu dictionary.
     *
     * @return the menu dictionary
     */
    public HashMap<String, List> getMenuDic() {
        return menuDic;
    }

    /**
     * Gets the rest name.
     *
     * @return the rest name
     */
    public String getRestName() {
        return restName;
    }
}
