package restaurant_profile_use_case;

import components.ScreenFactory;
import restaurant_order_history_use_case.OrderWatcherSingleton;
import user_shopping_cart_use_case.ShoppingCartSingleton;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class RestaurantProfilePanel extends JPanel implements RestaurantProfilePanelInterface {
    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Border emptyBorder3 = BorderFactory.createEmptyBorder(20, 0, 20, 0);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(30, 30, 30, 30);

    private final JLabel nameLabel = new JLabel("Name");
    private final JLabel emailLabel = new JLabel("Email");
    private final JLabel locationLabel = new JLabel("Location");
    private final JLabel phoneLabel = new JLabel("Phone");
    private final RestaurantProfileController restaurantProfileController;

    public RestaurantProfilePanel(RestaurantProfileController restaurantProfileController) {
        // initialize the controller
        this.restaurantProfileController = restaurantProfileController;

        // set the layout and color of the screen
        this.setOpaque(true);
        this.setBackground(GREY_WHITE);
        this.setLayout(new BorderLayout());

        // new title panel
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Restaurant Profile");
        titleLabel.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        titleLabel.setForeground(BG_DARK_GREEN);
        titlePanel.add(titleLabel);
        titlePanel.setOpaque(true);
        titlePanel.setBackground(GREY_WHITE);
        titlePanel.setBorder(emptyBorder2);

        this.add(titlePanel, BorderLayout.NORTH);

        JPanel centrePanel = new JPanel();
        centrePanel.setLayout(new GridLayout(6, 1));
        centrePanel.setOpaque(true);
        centrePanel.setBackground(BG_DARK_GREEN);

        JPanel namePanel = new JPanel();
        namePanel.setOpaque(false);
        nameLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        nameLabel.setForeground(GREY_WHITE);
        namePanel.setBorder(emptyBorder3);
        namePanel.add(nameLabel);
        centrePanel.add(namePanel);

        JPanel emailPanel = new JPanel();
        emailPanel.setOpaque(false);
        emailLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        emailLabel.setForeground(GREY_WHITE);
        emailPanel.setBorder(emptyBorder3);
        emailPanel.add(emailLabel);
        centrePanel.add(emailPanel);

        JPanel locationPanel = new JPanel();
        locationPanel.setOpaque(false);
        locationLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        locationLabel.setForeground(GREY_WHITE);
        locationLabel.setBorder(emptyBorder3);
        locationPanel.add(locationLabel);
        centrePanel.add(locationPanel);

        JPanel phonePanel = new JPanel();
        phonePanel.setOpaque(false);
        phoneLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        phoneLabel.setForeground(GREY_WHITE);
        phoneLabel.setBorder(emptyBorder3);
        phonePanel.add(phoneLabel);
        centrePanel.add(phonePanel);

        JPanel containCentre = new JPanel();
        containCentre.setOpaque(false);
        containCentre.setLayout(new BorderLayout());
        containCentre.add(centrePanel, BorderLayout.CENTER);
        containCentre.setBorder(emptyBorder2);

        this.add(containCentre, BorderLayout.CENTER);

        // Add button panel
        LayoutManager gridLayout1 = new GridLayout(0,3);
        JPanel buttonsPanel = new JPanel(gridLayout1);

        JButton changeInfoButton = new JButton("Change Info");
        changeInfoButton.setOpaque(false);
        changeInfoButton.setFont(new Font("Serif", Font.BOLD, 15));
        changeInfoButton.setForeground(BG_DARK_GREEN);
        changeInfoButton.addActionListener(new ActionListener() {
            /**
             * display the change restaurant info screen
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                showChangeRestaurantInfoScreen();
            }
        });
        buttonsPanel.add(changeInfoButton);

        JButton changePasswordButton = new JButton("Change Password");
        changePasswordButton.setOpaque(false);
        changePasswordButton.setFont(new Font("Serif", Font.BOLD, 15));
        changePasswordButton.setForeground(BG_DARK_GREEN);
        changePasswordButton.addActionListener(new ActionListener() {
            /**
             * display the change password screen
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                showChangePasswordScreen();
            }
        });
        buttonsPanel.add(changePasswordButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setOpaque(false);
        logoutButton.setFont(new Font("Serif", Font.BOLD, 15));
        logoutButton.setForeground(BG_DARK_GREEN);
        logoutButton.addActionListener(new ActionListener() {
            /**
             * log out of the current account
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });
        buttonsPanel.add(logoutButton);
        buttonsPanel.setBorder(emptyBorder2);
        buttonsPanel.setOpaque(false);

        this.add(buttonsPanel, BorderLayout.SOUTH);
    }

    /**
     * update the name label on the screen
     * @param newName new name after change
     */

    @Override
    public void updateNameLabel(String newName) {
        nameLabel.setText(newName);
    }

    /**
     * update the email label
     * @param newEmail new email after change
     */

    @Override
    public void updateEmailLabel(String newEmail) {
        emailLabel.setText(newEmail);
    }

    /**
     * update the location label
     * @param newLocation new location after change
     */

    @Override
    public void updateLocationLabel(String newLocation) {
        locationLabel.setText(newLocation);
    }

    /**
     * update the phone label
     * @param newPhone new phone number after change
     */

    @Override
    public void updatePhoneLabel(String newPhone) {
        phoneLabel.setText(newPhone);
    }

    /**
     * update all data in the panel
     */
    @Override
    public void updatePanelData() {
        restaurantProfileController.getRestaurantProfile();
    }

    /**
     * initiate a new change password screen
     */
    public void showChangePasswordScreen() {
        ScreenFactory screenFactory = new ScreenFactory();
        screenFactory.createChangePasswordScreen(restaurantProfileController.getCurrentRestaurantId());
    }

    /**
     * initiate a new change restaurant info screen
     */
    public void showChangeRestaurantInfoScreen() {
        ScreenFactory screenFactory = new ScreenFactory();
        screenFactory.createChangeRestaurantInfoScreen(restaurantProfileController.getCurrentRestaurantId());
    }

    /**
     * log out of the current account
     */
    public void logout() {
        ShoppingCartSingleton.setSingletonInstance(new ShoppingCartSingleton(null, new HashMap<>()));
        OrderWatcherSingleton.getOrderWatcherSingletonInstance().getOrderWatcher().interrupt();

        java.awt.Window[] win = java.awt.Window.getWindows();

        for(Window curWin: win){
            curWin.dispose();
        }

        ScreenFactory screenFactory = new ScreenFactory();
        screenFactory.createWelcomeScreen();
    }
}
