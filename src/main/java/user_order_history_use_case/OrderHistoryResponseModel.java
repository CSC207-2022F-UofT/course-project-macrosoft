package user_order_history_use_case;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is the response model of the user order history.
 */
public class OrderHistoryResponseModel {
    private ArrayList<HashMap<String, Object>> orders;

    private String name;

    /**
     * Constructor for OrderHistoryResponseModel
     *
     * @param orders the orders
     * @param name   the name
     */
    public OrderHistoryResponseModel(ArrayList<HashMap<String, Object>> orders, String name) {
        this.orders = orders;
        this.name = name;
    }

    /**
     * Gets orders.
     *
     * @return the orders
     */
    public ArrayList<HashMap<String, Object>> getOrders() {
        return orders;
    }

    /**
     * Sets orders
     *
     * @param orders the orders
     */
    public void setOrders(ArrayList<HashMap<String, Object>> orders) {
        this.orders = orders;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
}
