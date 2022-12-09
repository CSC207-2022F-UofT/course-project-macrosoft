package restaurant_verify_use_case;

import components.ScreenFactory;
import org.bson.types.ObjectId;
import components.LabelTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class VerifyResScreen extends JFrame implements VerifyResScreenInterface, ActionListener {
    VerifyResController verifyResController;

    JTextField verificationCode = new JTextField(15);

    public VerifyResScreen(VerifyResController controller) {

        this.verifyResController = controller;
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JLabel title = new JLabel("Verify Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel verificationCodeInfo = new LabelTextPanel(
                new JLabel("Verification Code"), verificationCode);

        JButton generateEmail = new JButton("Generate Email");
        JButton logIn = new JButton("Verify");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(generateEmail);
        buttons.add(logIn);
        buttons.add(cancel);

        generateEmail.addActionListener(this);
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
            verifyResController.verifyRes(verificationCode.getText());
        } else if (evt.getActionCommand().equals("Generate Email")) {
            verifyResController.generateEmail();
        } else if (evt.getActionCommand().equals("Cancel")) {
            this.showLoginScreen();
            this.dispose();
        }
    }

    @Override
    public JFrame getFrame() {
        return this;
    }

    /**
     * initiate a new login screen
     */
    public void showLoginScreen() {
        ScreenFactory screenFactory = new ScreenFactory();
        screenFactory.createLoginSreen();
    }

    /**
     * initiate a new restaurant homepage
     *
     * @param restaurantId   id of the current restaurant
     * @param restaurantName name of the current restaurant
     */
    public void showRestaurantHomePage(ObjectId restaurantId, String restaurantName) {
        ScreenFactory screenFactory = new ScreenFactory();
        screenFactory.createRestaurantHomepageScreen(restaurantId, restaurantName);
    }

    /**
     * show a message to the user
     *
     * @param message the message to be shown
     */
    public void showMessage(String message) {
        showMessageDialog(null, message);
    }

    /**
     * Close the current screen
     */
    @Override
    public void close() {
        this.dispose();
    }
}
