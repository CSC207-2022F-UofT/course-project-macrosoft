package change_password_use_case;

import javax.swing.*;

public interface ChangePasswordScreenInterface {
    public void close();
    public void showMessage(String message);
    public JFrame getFrame();
}
