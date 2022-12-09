package change_password_use_case;

import javax.swing.*;

// Interface adapters layer

/**
 * This interface is the screen interface for the change password use case.
 * The ChangePasswordScreen implements it
 */
public interface ChangePasswordScreenInterface {

    /**
     * Close the current screen
     */
    void close();


    /**
     * Display the resulting message
     *
     * @param message resulting message
     */
    void showMessage(String message);

    /**
     * Return the current frame
     *
     * @return this frame
     */
    JFrame getFrame();
}
