package change_restaurant_info_use_case;

public class ChangeRestaurantInfoProcessor implements ChangeRestaurantInfoPresenter{
    ChangeRestaurantInfoScreenInterface screen;


    public ChangeRestaurantInfoProcessor(ChangeRestaurantInfoScreenInterface screen) {
        this.screen = screen;
    }

    /**
     * @param message success message
     */
    @Override
    public void changeRestaurantInfoSuccess(String message) {
        this.screen.showMessage(message);
        this.screen.close();
    }

    /**
     * @param message failed message
     */
    @Override
    public void changeRestaurantInfoFailed(String message) {
        this.screen.showMessage(message);
    }

    /**
     * return the current screen
     * @return this screen
     */
    public ChangeRestaurantInfoScreenInterface getScreen() {
        return screen;
    }

    /**
     * set the scrent screen to the given new screen
     * @param screen new screen
     */
    public void setScreen(ChangeRestaurantInfoScreenInterface screen) {
        this.screen = screen;
    }
}
