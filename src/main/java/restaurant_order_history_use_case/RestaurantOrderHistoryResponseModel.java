package restaurant_order_history_use_case;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RestaurantOrderHistoryResponseModel {
    private ArrayList<HashMap<String, Object>> orderInfo;

    public RestaurantOrderHistoryResponseModel(ArrayList<HashMap<String, Object>> orderInfo) {
        this.orderInfo = orderInfo;
    }

    public ArrayList<HashMap<String, Object>> getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(ArrayList<HashMap<String, Object>> orderInfo) {
        this.orderInfo = orderInfo;
    }
}
