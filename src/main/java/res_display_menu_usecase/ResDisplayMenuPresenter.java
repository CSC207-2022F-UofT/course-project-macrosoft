package res_display_menu_usecase;

/**
 * This class is the processor for the display menu use case.
 */
public class ResDisplayMenuPresenter implements ResDisplayMenuOutputBoundary {

    private ResDisplayMenuPanelInterface displayMenuPanel;

    /**
     * Constructor for ResDisplayMenuPresenter
     *
     * @param displayMenuPanel the display menu panel
     */
    public ResDisplayMenuPresenter(ResDisplayMenuPanelInterface displayMenuPanel) {
        this.displayMenuPanel = displayMenuPanel;
    }

    /**
     * set the menu panel to the given menu panel
     *
     * @param displayMenuPanel new menu panel
     */
    public void setDisplayMenuPanel(ResDisplayMenuPanelInterface displayMenuPanel) {
        this.displayMenuPanel = displayMenuPanel;
    }

    /**
     * update the name and menu label on the panel, according to the response model
     *
     * @param responseModel response model
     */
    @Override
    public void presentMenu(ResDisplayMenuResponseModel responseModel) {
        displayMenuPanel.updateNameLabel(responseModel.getRestName());
        displayMenuPanel.updateMenuPanel(responseModel.getMenuDic());
    }
}
