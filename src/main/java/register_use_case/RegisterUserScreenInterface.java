package register_use_case;

import org.bson.types.ObjectId;

import javax.swing.*;

public interface RegisterUserScreenInterface {
    void close();
    JFrame getFrame();
    void showWelcomePage();
    void showMessage(String message);
}
