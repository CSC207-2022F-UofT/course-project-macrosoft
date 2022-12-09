package change_restaurant_info_use_case;

import javax.swing.*;

/**
 * Screen interface of the change restaurant info use case
 */

public interface ChangeRestaurantInfoScreenInterface {
    /**
     * close the current screen
     */
    void close();

    /**
     * show the message
     *
     * @param message the message
     */
    void showMessage(String message);

    /**
     * get the current frame
     *
     * @return the current frame
     */
    JFrame getFrame();
}
