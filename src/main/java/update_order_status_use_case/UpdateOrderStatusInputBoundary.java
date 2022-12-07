package update_order_status_use_case;

//Application Business Rule layer

import org.bson.types.ObjectId;

public interface UpdateOrderStatusInputBoundary {

    void updateOrderStatus(UpdateOrderStatusRequestModel request);

    String getOrderStatus(ObjectId orderID);






}
