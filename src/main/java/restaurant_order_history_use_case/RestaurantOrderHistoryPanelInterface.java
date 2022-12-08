package restaurant_order_history_use_case;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This interface is the panel for the restaurant order history use case.
 */
public interface RestaurantOrderHistoryPanelInterface {
    /**
     * Sets the order information.
     *
     * @param orderInfos the order information
     */
    void setOrder(ArrayList<HashMap<String, Object>> orderInfos);

    /**
     * Updates the order information.
     */
    void updateOrder();

    /**
     * Shows a message.
     *
     * @param message the message
     */
    void showMessage(String message);
}
