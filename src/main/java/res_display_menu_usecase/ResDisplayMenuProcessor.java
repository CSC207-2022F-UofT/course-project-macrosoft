package res_display_menu_usecase;

public class ResDisplayMenuProcessor implements ResDisplayMenuPresenter {

    private ResDisplayMenuPanelInterface displayMenuPanel;

    public ResDisplayMenuProcessor(ResDisplayMenuPanelInterface displayMenuPanel) {
        this.displayMenuPanel = displayMenuPanel;
    }

    public ResDisplayMenuPanelInterface getDisplayMenuPanel() {
        return displayMenuPanel;
    }

    public void setDisplayMenuPanel(ResDisplayMenuPanelInterface displayMenuPanel) {
        this.displayMenuPanel = displayMenuPanel;
    }

    @Override
    public void presentMenu(ResDisplayMenuResponseModel responseModel) {
        displayMenuPanel.updateNameLabel(responseModel.getRestName());
        displayMenuPanel.updateMenuPanel(responseModel.getMenuDic());
    }
}
