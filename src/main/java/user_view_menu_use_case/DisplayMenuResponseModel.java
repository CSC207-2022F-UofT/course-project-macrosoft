package user_view_menu_use_case;

import java.util.HashMap;
import java.util.List;

/**
 * This class is the response model of view menu use case.
 */
public class DisplayMenuResponseModel {

    private final HashMap<String, List> menuDic;

    private final String restName;
    private final String restAddress;
    private final String restPhone;

    /**
     * Constructor of DisplayMenuResponseModel.
     *
     * @param menuDic     a menu dictionary
     * @param restName    a restaurant name
     * @param restAddress a restaurant address
     * @param restPhone   a restaurant phone
     */
    public DisplayMenuResponseModel(HashMap<String, List> menuDic, String restName, String restAddress, String restPhone) {
        this.menuDic = menuDic;
        this.restName = restName;
        this.restAddress = restAddress;
        this.restPhone = restPhone;
    }

    /**
     * Gets menu dictionary.
     *
     * @return a menu dictionary
     */
    public HashMap<String, List> getMenuDic() {
        return menuDic;
    }

    /**
     * Gets restaurant name.
     *
     * @return a restaurant name
     */
    public String getRestName() {
        return restName;
    }

    /**
     * Gets restaurant address.
     *
     * @return a restaurant address
     */
    public String getRestAddress() {
        return restAddress;
    }

    /**
     * Gets restaurant phone.
     *
     * @return a restaurant phone
     */
    public String getRestPhone() {
        return restPhone;
    }
}
