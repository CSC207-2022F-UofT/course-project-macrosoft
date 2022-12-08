package user_view_menu_use_case;

/**
 * presenter of the use case.
 */
public interface DisplayMenuPresenter {
    /**
     * Present menu with the given response model.
     *
     * @param responseModel response model
     */
    void presentMenu(DisplayMenuResponseModel responseModel);

    /**
     * Set the display menu panel.
     *
     * @param displayMenuPanel display menu panel
     */
    void setDisplayMenuPanel(DisplayMenuPanelInterface displayMenuPanel);

}
