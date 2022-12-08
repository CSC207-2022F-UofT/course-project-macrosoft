package update_order_status_use_case;

public class UpdateOrderStatusProcessor implements UpdateOrderStatusPresenter {
    UpdateOrderStatusScreenInterface screen;

    public UpdateOrderStatusProcessor(UpdateOrderStatusScreenInterface screen) {
        this.screen = screen;
    }

    /**
     * return the current screen
     * @return this screen
     */
    public UpdateOrderStatusScreenInterface getScreen() {
        return screen;
    }

    /**
     * set the current screen
     * @param screen new screen
     */
    public void setScreen(UpdateOrderStatusScreenInterface screen) {
        this.screen = screen;
    }


    /**
     * when update order status success, close the screen
     */
    @Override
    public void prepareSuccessView() {
        screen.close();
    }

    /**
     * when update order status failed
     * @param message display the message
     */
    @Override
    public void prepareFailView(String message) {

    }
}
