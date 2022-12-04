package login_use_case;

import change_user_info_use_case.*;
import screens.LabelTextPanel;
import verify_user_use_case.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class UserLoginScreen extends JFrame implements ActionListener, UserLoginScreenInterface {
    /**
     * The username chosen by the user
     */
    JTextField username = new JTextField(15);
    /**
     * The password
     */
    JPasswordField password = new JPasswordField(15);

    UserLoginController userLoginController;

    /**
     * A window with a title and a JButton.
     */
    public UserLoginScreen(UserLoginController controller) {

        this.userLoginController = controller;

        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), password);

        JButton logIn = new JButton("Log in");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(logIn);
        buttons.add(cancel);

        logIn.addActionListener(this);
        cancel.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(usernameInfo);
        main.add(passwordInfo);
        main.add(buttons);
        this.setContentPane(main);

        this.pack();
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Log in")) {
            try {
                UserLoginResponseModel userLoginResponseModel = userLoginController.login(username.getText(),
                        String.valueOf(password.getPassword()));
                System.out.println(userLoginResponseModel.getResponseCode());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        else if (evt.getActionCommand().equals("Cancel")) {
           this.dispose();
           System.exit(0);
        }
    }

    @Override
    public void showVerifiedScreen() {
        VerifyUserPresenter verifyUserPresenter = new VerifyUserProcessor(null);
        VerifyUserFacade verifyUserFacade = new VerifyUserFacade(verifyUserPresenter);
        VerifyUserController verifyUserController = new VerifyUserController(verifyUserFacade);
        VerifyUserScreenInterface verifyUserScreen = new VerifyUserScreen(verifyUserController);

        verifyUserPresenter.setVerifyUserScreen(verifyUserScreen);

        verifyUserScreen.getFrame().setVisible(true);
    }

    @Override
    public void close() {
        this.dispose();
    }

    @Override
    public JFrame getFrame() {
        return this;
    }
}
