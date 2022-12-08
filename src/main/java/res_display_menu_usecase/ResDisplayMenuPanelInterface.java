package res_display_menu_usecase;

import java.util.HashMap;
import java.util.List;

/**
 * Interface of the menu panel
 */
@SuppressWarnings("rawtypes")
public interface ResDisplayMenuPanelInterface {

    /**
     * Updates the name label.
     *
     * @param newName the new name
     */
    void updateNameLabel(String newName);

    /**
     * Updates the menu panel.
     *
     * @param menuDic the new menu dictionary
     */
    void updateMenuPanel(HashMap<String, List> menuDic);

    /**
     * Updates the panel data.
     */
    void updatePanelData();
}
