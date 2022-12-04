package change_user_info_use_case;

import javax.swing.*;

import java.awt.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class ChangeUserInfoScreen extends JFrame implements ChangeUserInfoScreenInterface {
    ChangeUserInfoController controller;

    public ChangeUserInfoScreen(ChangeUserInfoController controller) {
        this.controller = controller;
    }

    /**
     *
     */
    @Override
    public void close() {
        this.dispose();
    }

    /**
     * @param message
     */
    @Override
    public void showMessage(String message) {
        showMessageDialog(null, message);
    }

    /**
     * @return a JFrame object representation of self
     */
    @Override
    public JFrame getFrame() {
        return this;
    }
}
