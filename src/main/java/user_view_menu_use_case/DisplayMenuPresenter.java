package user_view_menu_use_case;

/**
 * This class is the processor of view menu use case.
 */
public class DisplayMenuPresenter implements DisplayMenuOutputBoundary {

    private DisplayMenuPanelInterface displayMenuPanel;

    /**
     * Constructor of DisplayMenuPresenter.
     *
     * @param displayMenuPanel a display menu panel
     */
    public DisplayMenuPresenter(DisplayMenuPanelInterface displayMenuPanel) {
        this.displayMenuPanel = displayMenuPanel;
    }

    /**
     * Sets the panel to the given panel
     *
     * @param displayMenuPanel new panel
     */
    public void setDisplayMenuPanel(DisplayMenuPanelInterface displayMenuPanel) {
        this.displayMenuPanel = displayMenuPanel;
    }

    /**
     * Updates panel information according to the given response model
     *
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
