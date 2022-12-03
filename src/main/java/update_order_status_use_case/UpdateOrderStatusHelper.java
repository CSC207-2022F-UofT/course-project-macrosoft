package update_order_status_use_case;

// Application Business Rule Layer

import entities.Order;


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
