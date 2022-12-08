package update_order_status_use_case;

// Interface adapter layer

/**
 * This class is the processor which implements presenter of update order status use case.
 */
public class UpdateOrderStatusPresenter implements UpdateOrderStatusOutputBoundary {

    private UpdateOrderStatusScreenInterface screen;

    /**
     * Constructor for UpdateOrderStatusPresenter
     *
     * @param screen UpdateOrderStatusScreenInterface current screen
     */
    public UpdateOrderStatusPresenter(UpdateOrderStatusScreenInterface screen) {
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
     */
    @Override
    public void prepareFailView(String str) {
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
