package screens;

import verify_user_use_case.VerifyUserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerifyScreen extends JFrame implements ActionListener {

    VerifyUserController verifyUserController;

    JTextField verificationCode = new JTextField(15);

    public VerifyScreen(VerifyUserController controller) {

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
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
