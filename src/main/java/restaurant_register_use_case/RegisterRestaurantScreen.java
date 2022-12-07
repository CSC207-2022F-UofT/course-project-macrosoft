package restaurant_register_use_case;

import components.LabelTextPanel;
import components.ScreenFactory;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class RegisterRestaurantScreen extends JFrame implements RegisterRestaurantScreenInterface, ActionListener {
    /**
     * The username chosen by the user
     */
    JTextField email = new JTextField(15);
    JTextField username = new JTextField(15);
    /**
     * The password
     */
    JPasswordField password = new JPasswordField(15);
    JTextField restaurantName = new JTextField(15);
    JTextField location = new JTextField(30);
    JTextField phone = new JTextField(15);
    RegisterRestaurantController registerRestaurantController;

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Border emptyBorder = BorderFactory.createEmptyBorder(50, 30, 0, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 100, 0, 100);


    /**
     * A window with a title and a JButton.
     */
    public RegisterRestaurantScreen(RegisterRestaurantController controller) {

        // set the frame
        this.registerRestaurantController = controller;
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
                new JLabel("Restaurant Name"), restaurantName);
        LabelTextPanel lastNameInfo = new LabelTextPanel(
                new JLabel("Phone"), phone);

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
                registerRestaurantController.register(
                        restaurantName.getText(),
                        username.getText(),
                        String.valueOf(password.getPassword()),
                        email.getText(),
                        location.getText(),
                        phone.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else if (evt.getActionCommand().equals("Cancel")) {
            showWelcomePage();

            this.dispose();
        }
    }

    /**
     *
     * @param message resulting message to display
     */
    public void showMessage(String message) {
        showMessageDialog(null, message);
    }

    /**
     * show the welcome page
     */
    public void showWelcomePage() {
        ScreenFactory screenFactory = new ScreenFactory();
        screenFactory.createWelcomeScreen();
    }

    /**
     * close the frame
     */

    @Override
    public void close() {
        this.dispose();
    }


    /**
     * return the frame
     * @return this frame
     */
    @Override
    public JFrame getFrame() {
        return this;
    }
}
