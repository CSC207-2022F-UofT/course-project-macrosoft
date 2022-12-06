package update_order_status_use_case;

import javax.swing.*;

public interface UpdateOrderStatusScreenInterface {
    void close();
    void showMessage(String message);
    JFrame getFrame();
}
