package update_order_status_use_case;

// Interface adapter layer

/**
 * This class is the processor which implements presenter of update order status use case.
 */
public class UpdateOrderStatusProcessor implements UpdateOrderStatusPresenter{

    private UpdateOrderStatusScreenInterface screen;

    /**
     * Constructor for UpdateOrderStatusProcessor
     *
     * @param screen UpdateOrderStatusScreenInterface current screen
     */
    public  UpdateOrderStatusProcessor(UpdateOrderStatusScreenInterface screen) {
        this.screen = screen;
    }

    /**
     * Get current screen
     *
     * @return UpdateOrderStatusScreenInterface current screen
     */
    public UpdateOrderStatusScreenInterface getScreen() {
        return screen;
    }

    /**
     * This method override the same method in the presenter.
     * Handle the case when update order status is successful.
     *
     * @return null
     */
    @Override
    public void prepareSuccessView() {
        screen.close();
    }

    /**
     * This method override the same method in the presenter.
     * Handle the case when update order status is failed.
     *
     * @param str String fail message
     *
     * @return null
     */
    @Override
    public UpdateOrderStatusResponseModel prepareFailView(String str) {
        return null;
    }

    /**
     * This method override the same method in the presenter.
     * Set the screen
     *
     * @param screen UpdateOrderStatusScreenInterface current screen
     */
    @Override
    public void setScreen(UpdateOrderStatusScreenInterface screen) {
        this.screen = screen;
    }
}
