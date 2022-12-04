package verify_user_use_case;

import login_use_case.*;
import screens.LabelTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerifyUserScreen extends JFrame implements ActionListener, VerifyUserScreenInterface {

    VerifyUserController verifyUserController;

    JTextField verificationCode = new JTextField(15);

    public VerifyUserScreen(VerifyUserController controller) {

        this.verifyUserController = controller;

        JLabel title = new JLabel("Verify Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel verificationCodeInfo = new LabelTextPanel(
                new JLabel("Verification Code"), verificationCode);

        JButton logIn = new JButton("Verify");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(logIn);
        buttons.add(cancel);

        logIn.addActionListener(this);
        cancel.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(verificationCodeInfo);
        main.add(buttons);
        this.setContentPane(main);

        this.pack();
    }

    /**
     * @param evt the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Verify")) {
        }
        else if (evt.getActionCommand().equals("Cancel")) {
            this.showLoginScreen();
            this.dispose();
        }
    }

    @Override
    public JFrame getFrame() {
        return this;
    }

    public void showLoginScreen() {
        UserLoginPresenter userLoginPresenter = new UserLoginProcessor(null);
        UserLoginInputBoundary userLoginInteractor = new UserLoginInteractor(userLoginPresenter);
        UserLoginController userLoginController = new UserLoginController(userLoginInteractor);
        UserLoginScreenInterface screen = new UserLoginScreen(userLoginController);

        userLoginPresenter.setLoginScreen(screen);

        screen.getFrame().setVisible(true);
    }
}
