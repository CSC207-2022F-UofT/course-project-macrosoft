package res_display_menu_usecase;

/**
 * This class is the input boundary for the display menu use case.
 */
public interface ResDisplayMenuInputBoundary {

    /**
     * Displays the menu.
     *
     * @param requestModel the request model
     */
    void displayMenu(ResDisplayMenuRequestModel requestModel);
}
