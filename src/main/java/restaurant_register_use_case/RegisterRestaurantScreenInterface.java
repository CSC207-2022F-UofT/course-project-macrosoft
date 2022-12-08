package restaurant_register_use_case;
/*
interface of the screen
 */
import javax.swing.*;

public interface RegisterRestaurantScreenInterface {
    void close();
    JFrame getFrame();
    void showWelcomePage();
    void showMessage(String message);
}
