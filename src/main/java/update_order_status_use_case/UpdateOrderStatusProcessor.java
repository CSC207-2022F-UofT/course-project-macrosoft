package update_order_status_use_case;

// Interface adapter layer

public class UpdateOrderStatusProcessor implements UpdateOrderStatusPresenter{

    private UpdateOrderStatusScreenInterface screen;
    public  UpdateOrderStatusProcessor(UpdateOrderStatusScreenInterface screen) {
        this.screen = screen;
    }
    public UpdateOrderStatusScreenInterface getScreen() {
        return screen;
    }

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

    @Override
    public void setScreen(UpdateOrderStatusScreenInterface screen) {
        this.screen = screen;
    }
}
