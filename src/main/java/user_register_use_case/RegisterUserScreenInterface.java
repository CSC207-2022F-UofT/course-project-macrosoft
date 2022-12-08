package user_register_use_case;
/*
  interface of the screen
  the RegisterUserScreen implements it
 */

import javax.swing.*;

public interface RegisterUserScreenInterface {
    void close();
    JFrame getFrame();
    void showWelcomePage();
    void showMessage(String message);
}
