package verify_user_use_case;

import org.bson.types.ObjectId;

import javax.swing.*;

public interface VerifyUserScreenInterface {
    JFrame getFrame();
    void showUserHomepage(ObjectId userId);
    void close();
    void showMessage(String message);
}
