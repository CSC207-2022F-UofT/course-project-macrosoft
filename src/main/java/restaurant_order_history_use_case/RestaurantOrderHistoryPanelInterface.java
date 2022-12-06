package restaurant_order_history_use_case;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public interface RestaurantOrderHistoryPanelInterface {
    void setOrder(ArrayList<HashMap<String, Object>> orderInfos);
    void updateOrder();
    void showMessage(String message);
}
