package create_order_use_case;

import org.bson.types.ObjectId;
import org.springframework.validation.ObjectError;

import java.util.Dictionary;

public interface CreateOrderInputBoundary {
    void createOrder(Dictionary<ObjectId, Integer> orderList, ObjectId resId, ObjectId userId);
}
