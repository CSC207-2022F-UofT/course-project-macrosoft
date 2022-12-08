package change_user_info_use_case;
/*
screen interface of the change user information use case.
 */
import javax.swing.*;

public interface ChangeUserInfoScreenInterface {
    void close();
    void showMessage(String message);
    JFrame getFrame();
}
