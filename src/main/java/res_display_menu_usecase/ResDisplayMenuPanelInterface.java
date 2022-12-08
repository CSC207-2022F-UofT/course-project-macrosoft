package res_display_menu_usecase;
/*
Interface of the menu panel
 */

import java.util.HashMap;
import java.util.List;

@SuppressWarnings("rawtypes")
public interface ResDisplayMenuPanelInterface {
    void updateNameLabel(String newName);
    void updateMenuPanel(HashMap<String, List> menuDic);

    void updatePanelData();
}
