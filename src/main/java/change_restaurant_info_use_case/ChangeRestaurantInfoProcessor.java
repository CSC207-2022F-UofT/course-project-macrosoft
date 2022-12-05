package change_restaurant_info_use_case;

public class ChangeRestaurantInfoProcessor implements ChangeRestaurantInfoPresenter{
    ChangeRestaurantInfoScreenInterface screen;


    public ChangeRestaurantInfoProcessor(ChangeRestaurantInfoScreenInterface screen) {
        this.screen = screen;
    }

    /**
     * @param message
     */
    @Override
    public void changeRestaurantInfoSuccess(String message) {
        this.screen.showMessage(message);
        this.screen.close();
    }

    /**
     * @param message
     */
    @Override
    public void changeRestaurantInfoFailed(String message) {
        this.screen.showMessage(message);
    }

    public ChangeRestaurantInfoScreenInterface getScreen() {
        return screen;
    }

    public void setScreen(ChangeRestaurantInfoScreenInterface screen) {
        this.screen = screen;
    }
}
