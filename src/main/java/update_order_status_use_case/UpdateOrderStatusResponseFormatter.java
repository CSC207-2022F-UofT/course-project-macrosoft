package update_order_status_use_case;

// Interface adapter layer

public class UpdateOrderStatusResponseFormatter implements UpdateOrderStatusPresenter{

    public UpdateOrderStatusScreenInterface screen;

    public UpdateOrderStatusResponseFormatter(UpdateOrderStatusScreenInterface screen) {
        this.screen = screen;
    }

    public UpdateOrderStatusScreenInterface getScreen() {
        return this.screen;
    }

    public void setScreen(UpdateOrderStatusScreenInterface newScreen) {
        this.screen = newScreen;
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
     * @param str
     * @return
     */

    @Override
    public UpdateOrderStatusResponseModel prepareFailView(String str) {
        return null;
    }


}
