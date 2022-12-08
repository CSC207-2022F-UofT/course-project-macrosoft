package login_use_case;

import components.ScreenFactory;
import org.bson.types.ObjectId;
import components.LabelTextPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

import static javax.swing.JOptionPane.showMessageDialog;


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

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(50, 30, 0, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 100, 0, 100);


    /**
     * A window with a title and a JButton.
     */
    public UserLoginScreen(UserLoginController controller) {

        // set the frame
        this.userLoginController = controller;
        this.setSize(900, 700);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

         // the title panel
        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("Login To Your Account");
        title.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        title.setForeground(GREY_WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(title);
        titlePanel.setBorder(emptyBorder);
        titlePanel.setOpaque(false);

        //the username and password panel
        JPanel infoPanel = new JPanel();
        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), password);
        usernameInfo.setOpaque(true);
        passwordInfo.setOpaque(true);
        usernameInfo.setBackground(GREY_WHITE);
        passwordInfo.setBackground(GREY_WHITE);
        usernameInfo.setForeground(BG_DARK_GREEN);
        passwordInfo.setForeground(BG_DARK_GREEN);

        infoPanel.setOpaque(true);
        infoPanel.setBackground(GREY_WHITE);
        infoPanel.setBorder(emptyBorder2);
        infoPanel.setLayout(new GridLayout(0, 1));
        infoPanel.add(usernameInfo);
        infoPanel.add(passwordInfo);

        // the buttons
        JButton userLogIn = new JButton("Log in as User");
        JButton restaurantLogIn = new JButton("Log in as Restaurant");
        JButton cancel = new JButton("Cancel");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(userLogIn);
        buttonPanel.add(restaurantLogIn);
        buttonPanel.add(cancel);
        buttonPanel.setOpaque(true);
        buttonPanel.setBackground(BG_DARK_GREEN);
        buttonPanel.setBorder(emptyBorder);
        userLogIn.addActionListener(this);
        restaurantLogIn.addActionListener(this);
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
        if (evt.getActionCommand().equals("Log in as User")) {
            try {
                UserLoginResponseModel userLoginResponseModel = userLoginController.login(username.getText(),
                        String.valueOf(password.getPassword()));
                System.out.println(userLoginResponseModel.getResponseCode());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        else if (evt.getActionCommand().equals("Log in as Restaurant")) {
            try {
                UserLoginResponseModel userLoginResponseModel = userLoginController.loginAsRestaurant(username.getText(),
                        String.valueOf(password.getPassword()));
                System.out.println(userLoginResponseModel.getResponseCode());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        else if (evt.getActionCommand().equals("Cancel")) {
            ScreenFactory screenFactory = new ScreenFactory();
            screenFactory.createWelcomeScreen();
            this.close();
        }
    }

    /**
     * Initiate a new user verify screen through the screen factory.
     * @param userId id of the current user. type: ObjectId
     */
    @Override
    public void showVerifyScreen(ObjectId userId) {
        ScreenFactory screenFactory = new ScreenFactory();
        screenFactory.createVerifyUserScreen(userId);
    }

    /**
     * Initiate a new restaurant verify screen through the screen factory.
     * @param restaurantId id of the current restaurant. type: ObjectId
     */
    public void showRestaurantVerifyScreen(ObjectId restaurantId) {
        ScreenFactory screenFactory = new ScreenFactory();
        screenFactory.createVerifyRestaurantScreen(restaurantId);
    }

    /**
     * display the message for login result
     * @param message message to display
     */
    @Override
    public void showMessage(String message) {
        showMessageDialog(null, message);
    }

    /**
     * display the user homepage, called after successfully logged in
     * @param userId if of the current user
     */
    @Override
    public void showUserHomepage(ObjectId userId) {
        ScreenFactory screenFactory = new ScreenFactory();
        screenFactory.createUserHomepageScreen(userId);
    }

    /**
     * display the restaurant homepage, called after successfully logged in
     * @param restaurantId  id of the current restaurant
     * @param restaurantName   name of the current restaurant
     */
    public void showRestaurantHomepage(ObjectId restaurantId, String restaurantName) {
        ScreenFactory screenFactory = new ScreenFactory();
        screenFactory.createRestaurantHomepageScreen(restaurantId, restaurantName);
    }

    /**
     * close this screen
     */
    @Override
    public void close() {
        this.dispose();
    }

    /**
     * return this frame
     * @return the current frame
     */
    @Override
    public JFrame getFrame() {
        return this;
    }
}
