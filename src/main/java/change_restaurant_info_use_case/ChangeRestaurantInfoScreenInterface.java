package change_restaurant_info_use_case;

import javax.swing.*;


/**
  screen interface of the change restaurant info use case
 */
public interface ChangeRestaurantInfoScreenInterface {
    void close();

    void showMessage(String message);

    JFrame getFrame();
}
