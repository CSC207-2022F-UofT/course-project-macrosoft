package restaurant_order_history_use_case;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class is the response model for the restaurant order history use case.
 */
public class RestaurantOrderHistoryResponseModel {
    private final ArrayList<HashMap<String, Object>> orderInfo;

    /**
     * Constructor for the response model.
     *
     * @param orderInfo the order info
     */
    public RestaurantOrderHistoryResponseModel(ArrayList<HashMap<String, Object>> orderInfo) {
        this.orderInfo = orderInfo;
    }

    /**
     * Gets the order information.
     *
     * @return the order information in a list
     */
    public ArrayList<HashMap<String, Object>> getOrderInfo() {
        return orderInfo;
    }
}
