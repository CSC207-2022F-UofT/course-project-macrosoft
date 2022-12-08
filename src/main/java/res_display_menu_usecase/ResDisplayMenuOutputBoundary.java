package res_display_menu_usecase;

/**
 * presenter of the display menu use case.
 */
public interface ResDisplayMenuOutputBoundary {
    /**
     * Present the menu.
     *
     * @param responseModel the response model
     */
    void presentMenu(ResDisplayMenuResponseModel responseModel);

    /**
     * Sets the display menu panel.
     *
     * @param displayMenuPane the new display menu panel
     */
    void setDisplayMenuPanel(ResDisplayMenuPanelInterface displayMenuPane);

}
