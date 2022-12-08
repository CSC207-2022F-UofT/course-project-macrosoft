package user_view_menu_use_case;

public class DisplayMenuProcessor implements DisplayMenuPresenter{

    private DisplayMenuPanelInterface displayMenuPanel;

    public DisplayMenuProcessor(DisplayMenuPanelInterface displayMenuPanel) {
        this.displayMenuPanel = displayMenuPanel;
    }


    /**
     * set the panel to the given panel
     * @param displayMenuPanel new panel
     */
    public void setDisplayMenuPanel(DisplayMenuPanelInterface displayMenuPanel) {
        this.displayMenuPanel = displayMenuPanel;
    }

    /**
     * update panel information according to the given response model
     * @param responseModel response model
     */
    @Override
    public void presentMenu(DisplayMenuResponseModel responseModel) {
        displayMenuPanel.updateNameLabel(responseModel.getRestName());
        displayMenuPanel.updateAddressLabel(responseModel.getRestAddress());
        displayMenuPanel.updatePhoneLabel(responseModel.getRestPhone());
        displayMenuPanel.updateMenuPanel(responseModel.getMenuDic());
    }
}
