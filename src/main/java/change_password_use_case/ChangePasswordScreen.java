package change_password_use_case;

import screens.LabelTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

// Frameworks/Drivers layer

public class ChangePasswordScreen extends JFrame implements ChangePasswordScreenInterface, ActionListener {
    /**
     * The username chosen by the user
     */
    JTextField originalPassword = new JTextField(15);
    /**
     * The password
     */
    JPasswordField newPassword = new JPasswordField(15);
    /**
     * The password confirmation
     */
    JPasswordField confirmNewPassword = new JPasswordField(15);

    private ChangePasswordController changePasswordController;

    public ChangePasswordScreen(ChangePasswordController controller) {
        this.changePasswordController = controller;

        JLabel title = new JLabel("Change Password");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Original Password"), originalPassword);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("New Password"), newPassword);
        LabelTextPanel confirmPasswordInfo = new LabelTextPanel(
                new JLabel("Confirm New Password"), confirmNewPassword);

        JButton save = new JButton("Save");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(save);
        buttons.add(cancel);

        save.addActionListener(this);
        cancel.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(usernameInfo);
        main.add(passwordInfo);
        main.add(confirmPasswordInfo);
        main.add(buttons);
        this.setContentPane(main);

        this.pack();
    }

    /**
     * Close this frame
     */
    @Override
    public void close() {
        this.dispose();
    }

    /**
     * Displays a prompt message box with
     * @param message the message to be displayed in the prompt
     */
    @Override
    public void showMessage(String message) {
        showMessageDialog(null, message);
    }

    /**
     * @return the JFrame representation of this object
     */
    @Override
    public JFrame getFrame() {
        return this;
    }

    /**
     * @param evt the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Save")) {
            try {
                changePasswordController.changePassword(
                        originalPassword.getText(),
                        String.valueOf(newPassword.getPassword()),
                        String.valueOf(confirmNewPassword.getPassword())
                );
            } catch (Exception e) {
                showMessageDialog(this, e.getMessage());
            }
        }
        else if (evt.getActionCommand().equals("Cancel")) {
            this.close();
        }
    }
}
