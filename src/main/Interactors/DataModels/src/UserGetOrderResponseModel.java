import java.util.List;

public class UserGetOrderResponseModel {
    private List<Order> orders;

    public UserGetOrderResponseModel(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
