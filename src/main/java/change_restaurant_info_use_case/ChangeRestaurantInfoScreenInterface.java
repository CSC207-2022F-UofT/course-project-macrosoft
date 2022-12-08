package change_restaurant_info_use_case;

/*
  screen interface of the change restaurant info use case
 */

import javax.swing.*;

public interface ChangeRestaurantInfoScreenInterface {
    void close();
    void showMessage(String message);
    JFrame getFrame();
}
