package change_password_use_case;

import javax.swing.*;

// Interface adapters layer

/**
 * This interface is the screen interface for the change password use case.
 * The ChangePasswordScreen implements it
 */
public interface ChangePasswordScreenInterface {

    /**
     * close the current screen
     */
    void close();


    /**
     * display the resulting message
     * @param message resulting message
     */
    void showMessage(String message);

    /**
     * return the current frame
     * @return this frame
     */
    JFrame getFrame();
}
