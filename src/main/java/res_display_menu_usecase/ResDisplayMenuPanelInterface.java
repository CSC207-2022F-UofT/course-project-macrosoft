package res_display_menu_usecase;

import java.util.HashMap;
import java.util.List;

public interface ResDisplayMenuPanelInterface {
    void updateNameLabel(String newName);
    void updateMenuPanel(HashMap<String, List> menuDic);

    void updatePanelData();
}
