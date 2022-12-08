package user_view_menu_use_case;

/**
 * This interface is the input boundary of view menu use case.
 */
public interface DisplayMenuInputBoundary {

    /**
     * Display menu.
     *
     * @param requestModel a request model
     */
    void displayMenu(DisplayMenuRequestModel requestModel);
}
