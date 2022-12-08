package user_view_menu_use_case;
/*
interface of the screen
 */
import java.util.*;
@SuppressWarnings("rawtypes")
public interface DisplayMenuPanelInterface {
    void updateNameLabel(String newName);
    void updateMenuPanel(HashMap<String, List> menuDic);
    void updateAddressLabel(String newAddress);
    void updatePhoneLabel(String newPhone);
    void updatePanelData();
}
