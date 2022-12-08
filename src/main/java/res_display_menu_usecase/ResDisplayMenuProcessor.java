package res_display_menu_usecase;

public class ResDisplayMenuProcessor implements ResDisplayMenuPresenter {

    private ResDisplayMenuPanelInterface displayMenuPanel;

    public ResDisplayMenuProcessor(ResDisplayMenuPanelInterface displayMenuPanel) {
        this.displayMenuPanel = displayMenuPanel;
    }

    /**
     * set the menu panel to the given menu panel
     * @param displayMenuPanel new menu panel
     */
    public void setDisplayMenuPanel(ResDisplayMenuPanelInterface displayMenuPanel) {
        this.displayMenuPanel = displayMenuPanel;
    }

    /**
     * update the name and menu label on the panel, according to the response model
     * @param responseModel response model
     */
    @Override
    public void presentMenu(ResDisplayMenuResponseModel responseModel) {
        displayMenuPanel.updateNameLabel(responseModel.getRestName());
        displayMenuPanel.updateMenuPanel(responseModel.getMenuDic());
    }
}
