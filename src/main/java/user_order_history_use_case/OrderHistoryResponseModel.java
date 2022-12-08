package user_order_history_use_case;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderHistoryResponseModel {
    private ArrayList<HashMap<String, Object>> orders;

    private String name;

    public OrderHistoryResponseModel(ArrayList<HashMap<String, Object>> orders, String name) {
        this.orders = orders;
        this.name = name;
    }

    public ArrayList<HashMap<String, Object>> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<HashMap<String, Object>> orders) {
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
