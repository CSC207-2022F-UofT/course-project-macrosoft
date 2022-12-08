package res_display_menu_usecase;
/*
presenter of the display menu use case.
 */
public interface ResDisplayMenuPresenter {
    void presentMenu(ResDisplayMenuResponseModel responseModel);

    void setDisplayMenuPanel(ResDisplayMenuPanelInterface displayMenuPane);

}
