package change_user_info_use_case;

import javax.swing.*;

public interface ChangeUserInfoScreenInterface {
    void close();
    void showMessage(String message);
    JFrame getFrame();
}
