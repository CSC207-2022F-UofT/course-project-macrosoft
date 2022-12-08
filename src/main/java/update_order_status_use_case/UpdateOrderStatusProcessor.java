package update_order_status_use_case;

public class UpdateOrderStatusProcessor implements UpdateOrderStatusPresenter {
    UpdateOrderStatusScreenInterface screen;

    public UpdateOrderStatusProcessor(UpdateOrderStatusScreenInterface screen) {
        this.screen = screen;
    }

    public UpdateOrderStatusScreenInterface getScreen() {
        return screen;
    }

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

    @Override
    public void prepareFailView(String message) {
    }
}
