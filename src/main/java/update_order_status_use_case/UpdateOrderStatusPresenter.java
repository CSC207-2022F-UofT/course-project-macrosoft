package update_order_status_use_case;

// Interface Adaptors Layer

import restaurant_order_history_use_case.RestaurantOrderHistoryPanelInterface;

public interface UpdateOrderStatusPresenter {

    UpdateOrderStatusResponseModel prepareSuccessView();

    UpdateOrderStatusResponseModel prepareFailView(String message);

    void setScreen(UpdateOrderStatusScreenInterface screen);

}
