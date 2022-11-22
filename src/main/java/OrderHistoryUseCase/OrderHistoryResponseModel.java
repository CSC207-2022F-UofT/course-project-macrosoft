package OrderHistoryUseCase;

import Entities.Order;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class OrderHistoryResponseModel {
    private int responseCode;
    private ArrayList<Order> orders;

    public OrderHistoryResponseModel(int responseCode, ArrayList<Order> orders) {
        this.responseCode = responseCode;
        this.orders = orders;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
