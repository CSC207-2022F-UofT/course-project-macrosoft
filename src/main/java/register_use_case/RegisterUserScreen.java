package register_use_case;

import org.bson.types.ObjectId;
import restaurant_homepage_use_case.RestaurantHomepageController;
import restaurant_homepage_use_case.RestaurantHomepageScreen;
import screens.LabelTextPanel;
import user_homepage_use_case.UserHomePageScreen;
import user_homepage_use_case.UserHomepageController;
import verify_restaurant_use_case.*;
import verify_user_use_case.*;
import welcome_use_case.WelcomeScreen;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class RegisterUserScreen extends JFrame implements RegisterUserScreenInterface, ActionListener {
    /**
     * The username chosen by the user
     */
    JTextField email = new JTextField(15);
    JTextField username = new JTextField(15);
    /**
     * The password
     */
    JPasswordField password = new JPasswordField(15);
    JTextField firstName = new JTextField(15);
    JTextField lastName = new JTextField(15);
    RegisterUserController registerUserController;

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color BG_LIGHT_GREEN = new Color(87, 118, 83);
    private static final Color HL_LIGHT_GREEN = new Color(166, 199, 148);
    private static final Color HL_ORANGE_YELLOW = new Color(232, 181, 93);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Color WHITE = new Color(255, 255, 255);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(50, 30, 0, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 100, 0, 100);
    private static final Border emptyBorder3 = BorderFactory.createEmptyBorder(20, 0, 20, 0);
    private static final Border emptyBorder4 = BorderFactory.createEmptyBorder(10, 0, 0, 10);
    private static final Border blackline = BorderFactory.createLineBorder(Color.black);


    /**
     * A window with a title and a JButton.
     */
    public RegisterUserScreen(RegisterUserController controller) {

        // set the frame
        this.registerUserController = controller;
        this.setSize(900, 700);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // the title panel
        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("Register New Account");
        title.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        title.setForeground(GREY_WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(title);
        titlePanel.setBorder(emptyBorder);
        titlePanel.setOpaque(false);

        //the username and password panel
        JPanel infoPanel = new JPanel();
        LabelTextPanel emailInfo = new LabelTextPanel(
                new JLabel("Email"), email);
        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), password);
        LabelTextPanel firstNameInfo = new LabelTextPanel(
                new JLabel("First Name"), firstName);
        LabelTextPanel lastNameInfo = new LabelTextPanel(
                new JLabel("Last Name"), lastName);
        emailInfo.setOpaque(true);
        usernameInfo.setOpaque(true);
        passwordInfo.setOpaque(true);
        firstNameInfo.setOpaque(true);
        lastNameInfo.setOpaque(true);
        usernameInfo.setBackground(GREY_WHITE);
        passwordInfo.setBackground(GREY_WHITE);
        usernameInfo.setForeground(BG_DARK_GREEN);
        passwordInfo.setForeground(BG_DARK_GREEN);

        infoPanel.setOpaque(true);
        infoPanel.setBackground(GREY_WHITE);
        infoPanel.setBorder(emptyBorder2);
        infoPanel.setLayout(new GridLayout(0, 1));
        infoPanel.add(emailInfo);
        infoPanel.add(usernameInfo);
        infoPanel.add(passwordInfo);
        infoPanel.add(firstNameInfo);
        infoPanel.add(lastNameInfo);

        // the buttons
        JButton register = new JButton("Register");
        JButton cancel = new JButton("Cancel");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(register);
        buttonPanel.add(cancel);
        buttonPanel.setOpaque(true);
        buttonPanel.setBackground(BG_DARK_GREEN);
        buttonPanel.setBorder(emptyBorder);
        register.addActionListener(this);
        cancel.addActionListener(this);

        // creating the main panel
        JPanel main = new JPanel();
        main.setLayout(new GridLayout(0, 1));
        main.add(titlePanel);
        main.add(infoPanel);
        main.add(buttonPanel);
        main.setOpaque(true);
        main.setBackground(BG_DARK_GREEN);

        //add everything to the frame
        this.setContentPane(main);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Register")) {
            try {
                registerUserController.registerUser(
                        email.getText(),
                        username.getText(),
                        String.valueOf(password.getPassword()),
                        firstName.getText(),
                        lastName.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        else if (evt.getActionCommand().equals("Cancel")) {
            WelcomeScreen screen = new WelcomeScreen();
            this.dispose();
        }
    }

    public void showMessage(String message) {
        showMessageDialog(null, message);
    }

    public void showWelcomePage() {
        WelcomeScreen screen = new WelcomeScreen();
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
