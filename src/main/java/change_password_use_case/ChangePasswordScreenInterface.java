package change_password_use_case;

import javax.swing.*;

// Interface adapters layer

/**
 * This interface is the screen interface for the change password use case.
 */
public interface ChangePasswordScreenInterface {

    public void close();

    public void showMessage(String message);

    public JFrame getFrame();
}
