package register_user_use_case;

import javax.swing.*;

public interface RegisterUserScreenInterface {
    void close();
    JFrame getFrame();
    void showWelcomePage();
    void showMessage(String message);
}
