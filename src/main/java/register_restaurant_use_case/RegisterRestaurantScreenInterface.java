package register_restaurant_use_case;

import javax.swing.*;

public interface RegisterRestaurantScreenInterface {
    void close();
    JFrame getFrame();
    void showWelcomePage();
    void showMessage(String message);
}
