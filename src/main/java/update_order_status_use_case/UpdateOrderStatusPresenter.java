package update_order_status_use_case;

// Interface Adaptors Layer
/*
presenter of the use case
 */

public interface UpdateOrderStatusPresenter {

    void prepareSuccessView();

    void prepareFailView(String message);

    void setScreen(UpdateOrderStatusScreenInterface screen);

}
