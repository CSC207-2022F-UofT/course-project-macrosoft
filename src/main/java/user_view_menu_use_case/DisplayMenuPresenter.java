package user_view_menu_use_case;

public interface DisplayMenuPresenter {
    void presentMenu(DisplayMenuResponseModel responseModel);

    void setDisplayMenuPanel(DisplayMenuPanelInterface displayMenuPane);

}
