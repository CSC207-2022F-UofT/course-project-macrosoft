package user_order_history_use_case;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * The class is the response model for the order history use case.
 */
public class OrderHistoryResponseModel {
    private ArrayList<HashMap<String, Object>> orders;

    private String name;


    /**
     * The constructor for the OrderHistoryResponseModel
     *
     * @param orders List of ordered items
     * @param name Current username including first and last name
     */
    public OrderHistoryResponseModel(ArrayList<HashMap<String, Object>> orders, String name) {
        this.orders = orders;
        this.name = name;
    }


    /**
     * Get the list of orders
     *
     * @return the list of orders
     */
    public ArrayList<HashMap<String, Object>> getOrders() {
        return orders;
    }


    /**
     * Set the list of orders
     *
     * @param orders the list of orders to be set
     */
    public void setOrders(ArrayList<HashMap<String, Object>> orders) {
        this.orders = orders;
    }


    /**
     * Get the current username
     *
     * @return the current username
     */
    public String getName() {
        return name;
    }


    /**
     * Set the current username
     *
     * @param name the current username to be set
     */
    public void setName(String name) {
        this.name = name;
    }
}
