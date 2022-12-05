package change_restaurant_info_use_case;

import javax.swing.*;

public interface ChangeRestaurantInfoScreenInterface {
    void close();
    void showMessage(String message);
    JFrame getFrame();
}
