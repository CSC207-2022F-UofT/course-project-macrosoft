package UpdateOrderStatusUseCase;

// Application Business Rule Layer

import Entities.Order;
import Entities.*;
import org.bson.types.ObjectId;


public class UpdateOrderStatusHelper {
    /** this method updates order status with a String in the given Order object.
     *
     * @param curOrder the current order to be modified
     * @param newStatus new status of the order that need to be updated
     */

    public Order update(Order curOrder, String newStatus) {
        curOrder.setOrderStatus(newStatus);
        return curOrder;
    }
}
