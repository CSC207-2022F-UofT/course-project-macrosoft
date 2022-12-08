package update_order_status_use_case;

// Interface Adaptors Layer

public interface UpdateOrderStatusPresenter {

    void prepareSuccessView();

    void prepareFailView(String message);

    void setScreen(UpdateOrderStatusScreenInterface screen);

}
