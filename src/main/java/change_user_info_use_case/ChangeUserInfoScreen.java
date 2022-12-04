package change_user_info_use_case;

import screens.LabelTextPanel;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class ChangeUserInfoScreen extends JFrame implements ChangeUserInfoScreenInterface, ActionListener {
    /**
     * The username chosen by the user
     */
    JTextField newFirstName = new JTextField(15);
    /**
     * The password
     */
    JTextField newLastName = new JTextField(15);
    /**
     * The password confirmation
     */
    JTextField newEmail = new JTextField(15);

    ChangeUserInfoController controller;

    public ChangeUserInfoScreen(ChangeUserInfoController controller) {
        this.controller = controller;

        JLabel title = new JLabel("Change Password");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel firstNameInfo = new LabelTextPanel(
                new JLabel("New First Name"), newFirstName);
        LabelTextPanel lastNameInfo = new LabelTextPanel(
                new JLabel("New Last Name"), newLastName);
        LabelTextPanel emailInfo = new LabelTextPanel(
                new JLabel("New Email"), newEmail);

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
        main.add(firstNameInfo);
        main.add(lastNameInfo);
        main.add(emailInfo);
        main.add(buttons);
        this.setContentPane(main);

        this.pack();
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

    /**
     * @param evt the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Save")) {
            try {
                controller.changeUserInfo(
                        newFirstName.getText(),
                        newLastName.getText(),
                        newEmail.getText()
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
