package user_view_menu_use_case;
/*
presenter of the usecase.
 */
public interface DisplayMenuPresenter {
    void presentMenu(DisplayMenuResponseModel responseModel);

    void setDisplayMenuPanel(DisplayMenuPanelInterface displayMenuPane);

}
