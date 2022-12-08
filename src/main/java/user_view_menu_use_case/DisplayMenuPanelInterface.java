package user_view_menu_use_case;

import java.util.*;

/**
 * interface of the screen
 */
@SuppressWarnings("rawtypes")
public interface DisplayMenuPanelInterface {
    /**
     * Updates the name label
     *
     * @param newName the new name
     */
    void updateNameLabel(String newName);

    /**
     * Updates the menu panel
     *
     * @param menuDic the menu dictionary
     */
    void updateMenuPanel(HashMap<String, List> menuDic);

    /**
     * Updates the address label
     *
     * @param newAddress the new address
     */
    void updateAddressLabel(String newAddress);

    /**
     * Updates the phone label
     *
     * @param newPhone the new phone
     */
    void updatePhoneLabel(String newPhone);

    /**
     * Updates the panel data
     */
    void updatePanelData();
}
