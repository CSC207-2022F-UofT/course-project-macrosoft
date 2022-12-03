package datamodels;

public class IdGetOrderRequestModel {
    private String orderId;

    public IdGetOrderRequestModel(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
