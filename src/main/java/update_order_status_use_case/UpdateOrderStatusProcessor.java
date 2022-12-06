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
     * @return
     */
    @Override
    public UpdateOrderStatusResponseModel prepareSuccessView() {
        screen.close();
        return null;
    }

    /**
     * @param message
     * @return
     */
    @Override
    public UpdateOrderStatusResponseModel prepareFailView(String message) {
        return null;
    }
}
