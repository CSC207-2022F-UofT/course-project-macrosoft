package change_user_info_use_case;

import javax.swing.*;

/**
 * screen interface of the change user information use case.
 */
public interface ChangeUserInfoScreenInterface {
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
