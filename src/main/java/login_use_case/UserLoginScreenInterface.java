package login_use_case;

import javax.swing.*;

public interface UserLoginScreenInterface {
    void showVerifiedScreen();
    void close();
    JFrame getFrame();
}
