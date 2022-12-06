package restaurant_verify_use_case;

import login_use_case.*;
import org.bson.types.ObjectId;
import restaurant_homepage_use_case.RestaurantHomepageController;
import restaurant_homepage_use_case.RestaurantHomepageScreen;
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
        }
        else if (evt.getActionCommand().equals("Generate Email")) {
            verifyResController.generateEmail();
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
        RestaurantLoginInputBoundary restaurantLoginInteractor = new RestaurantLoginInteractor(userLoginPresenter);
        UserLoginController userLoginController = new UserLoginController(userLoginInteractor, restaurantLoginInteractor);
        UserLoginScreenInterface screen = new UserLoginScreen(userLoginController);

        userLoginPresenter.setLoginScreen(screen);

        screen.getFrame().setVisible(true);
    }

    public void showRestaurantHomePage(ObjectId restaurantId, String restaurantName) {
        RestaurantHomepageController restaurantHomepageController = new RestaurantHomepageController(restaurantId);
        RestaurantHomepageScreen restaurantHomepageScreen = new RestaurantHomepageScreen(restaurantHomepageController, restaurantName);
    }

    public void showMessage(String message) {
        showMessageDialog(null, message);
    }

    @Override
    public void close() {
        this.dispose();
    }


}
