package user_view_menu_use_case;

public class DisplayMenuProcessor implements DisplayMenuPresenter{

    private DisplayMenuPanelInterface displayMenuPanel;

    public DisplayMenuProcessor(DisplayMenuPanelInterface displayMenuPanel) {
        this.displayMenuPanel = displayMenuPanel;
    }

    public DisplayMenuPanelInterface getDisplayMenuPanel() {
        return displayMenuPanel;
    }

    public void setDisplayMenuPanel(DisplayMenuPanelInterface displayMenuPanel) {
        this.displayMenuPanel = displayMenuPanel;
    }

    @Override
    public void presentMenu(DisplayMenuResponseModel responseModel) {
        displayMenuPanel.updateNameLabel(responseModel.getRestName());
        displayMenuPanel.updateAddressLabel(responseModel.getRestAddress());
        displayMenuPanel.updatePhoneLabel(responseModel.getRestPhone());
        displayMenuPanel.updateMenuPanel(responseModel.getMenuDic());
    }
}
