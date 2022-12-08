package update_order_status_use_case;
/*
interface of the screen
 */
import javax.swing.*;

/**
 * This interface is the screen interface of the update order status use case.
 */
public interface UpdateOrderStatusScreenInterface {

    /**
     * This method close the screen.
     */
    void close();

    /**
     * This method shows the screen message
     * @param str String message appear on screen
     */
    void showMessage(String str);

    /**
     * This method get current frame
     * @return JFrame current frame
     */
    JFrame getFrame();
}
