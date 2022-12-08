package change_restaurant_info_use_case;

/**
 * This class is the processor for the change restaurant information use case.
 */
public class ChangeRestaurantInfoProcessor implements ChangeRestaurantInfoPresenter {
    ChangeRestaurantInfoScreenInterface screen;


    /**
     * The constructor for the change restaurant info processor
     *
     * @param screen the change restaurant info screen
     */
    public ChangeRestaurantInfoProcessor(ChangeRestaurantInfoScreenInterface screen) {
        this.screen = screen;
    }

    /**

     * Show change the restaurant information succeeded screen
     *
     * @param message the success message to be shown
     */
    @Override
    public void changeRestaurantInfoSuccess(String message) {
        this.screen.showMessage(message);
        this.screen.close();
    }

    /**

     * Show change the restaurant information failed screen
     *
     * @param message the failed message to be shown
     */
    @Override
    public void changeRestaurantInfoFailed(String message) {
        this.screen.showMessage(message);
    }



    /**
     * Get the change restaurant info screen
     *
     * @return the current change restaurant info screen
     */
    public ChangeRestaurantInfoScreenInterface getScreen() {
        return screen;
    }



    /**
     * Set the change restaurant info screen to the given screen
     *
     * @param screen the new change restaurant info screen
     */
    public void setScreen(ChangeRestaurantInfoScreenInterface screen) {
        this.screen = screen;
    }
}
