package update_order_status_use_case;
/*
interface of the screen
 */
import javax.swing.*;

public interface UpdateOrderStatusScreenInterface {
    void close();
    void showMessage(String message);
    JFrame getFrame();
}
