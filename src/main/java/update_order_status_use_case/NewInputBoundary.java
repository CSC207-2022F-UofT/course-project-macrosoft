package update_order_status_use_case;

import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.List;

public interface NewInputBoundary {
    void displayOrders(NewRequestModel requestModel);

    NewResponseModel getResponse(ObjectId userId);

    public  HashMap<String, List> getOrderDic(ObjectId resId);
}
