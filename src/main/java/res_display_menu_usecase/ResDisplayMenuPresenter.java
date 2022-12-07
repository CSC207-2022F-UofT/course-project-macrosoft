package res_display_menu_usecase;

public interface ResDisplayMenuPresenter {
    void presentMenu(ResDisplayMenuResponseModel responseModel);

    void setDisplayMenuPanel(ResDisplayMenuPanelInterface displayMenuPane);

}
