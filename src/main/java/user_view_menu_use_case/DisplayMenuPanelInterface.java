package user_view_menu_use_case;

import java.util.*;

public interface DisplayMenuPanelInterface {
    void updateNameLabel(String newName);
    void updateMenuPanel(HashMap<String, List> menuDic);

    void updatePanelData();
}
