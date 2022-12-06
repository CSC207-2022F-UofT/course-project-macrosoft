package restaurant_profile_use_case;

import change_password_use_case.*;
import change_restaurant_info_use_case.*;
import restaurant_order_history_use_case.OrderWatcherSingleton;
import user_shopping_cart_use_case.ShoppingCartSingleton;
import welcome_use_case.WelcomeScreen;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class RestaurantProfilePanel extends JPanel implements RestaurantProfilePanelInterface {
    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Border emptyBorder3 = BorderFactory.createEmptyBorder(200, 0, 20, 0);

    private JLabel nameLabel = new JLabel("Name");
    private JLabel emailLabel = new JLabel("Email");
    private JLabel locationLabel = new JLabel("Location");
    private JLabel phoneLabel = new JLabel("Phone");
    private RestaurantProfileController restaurantProfileController;

    public RestaurantProfilePanel(RestaurantProfileController restaurantProfileController) {
        this.restaurantProfileController = restaurantProfileController;

        GridLayout gridLayout = new GridLayout(0,1);

        JPanel centrePanel = new JPanel(gridLayout);
        centrePanel.setOpaque(false);
        nameLabel.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        nameLabel.setForeground(GREY_WHITE);
        nameLabel.setBorder(emptyBorder3);
        centrePanel.add(nameLabel);
        emailLabel.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        emailLabel.setForeground(GREY_WHITE);
        emailLabel.setBorder(emptyBorder3);
        centrePanel.add(emailLabel);
        locationLabel.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        locationLabel.setForeground(GREY_WHITE);
        locationLabel.setBorder(emptyBorder3);
        centrePanel.add(locationLabel);
        phoneLabel.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        phoneLabel.setForeground(GREY_WHITE);
        phoneLabel.setBorder(emptyBorder3);
        centrePanel.add(phoneLabel);

        this.add(centrePanel, BorderLayout.CENTER);

        // Add button panel
        LayoutManager gridLayout1 = new GridLayout(0,3);
        JPanel buttonsPanel = new JPanel(gridLayout1);

        JButton changeInfoButton = new JButton("Change Info");
        changeInfoButton.setOpaque(false);
        changeInfoButton.setFont(new Font("Serif", Font.BOLD, 15));
        changeInfoButton.setForeground(BG_DARK_GREEN);
        changeInfoButton.addActionListener(new ActionListener() {
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
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });
        buttonsPanel.add(logoutButton);

        this.add(buttonsPanel, BorderLayout.SOUTH);
    }

    @Override
    public void updateNameLabel(String newName) {
        nameLabel.setText(newName);
    }

    @Override
    public void updateEmailLabel(String newEmail) {
        emailLabel.setText(newEmail);
    }

    @Override
    public void updateLocationLabel(String newLocation) {
        locationLabel.setText(newLocation);
    }

    @Override
    public void updatePhoneLabel(String newPhone) {
        phoneLabel.setText(newPhone);
    }

    @Override
    public void updatePanelData() {
        restaurantProfileController.getRestaurantProfile();
    }

    public void showChangePasswordScreen() {
        ChangePasswordPresenter changePasswordPresenter = new ChangePasswordProcessor(null);
        ChangePasswordInputBoundary changePasswordInputBoundary = new ChangePasswordInteractor(changePasswordPresenter);
        ChangePasswordController changePasswordController = new ChangePasswordController(
                changePasswordInputBoundary,
                restaurantProfileController.getCurrentRestaurantId());

        ChangePasswordScreenInterface changePasswordScreen = new ChangePasswordScreen(changePasswordController);

        changePasswordPresenter.setChangePasswordScreenInterface(changePasswordScreen);

        changePasswordScreen.getFrame().setVisible(true);
    }

    public void showChangeRestaurantInfoScreen() {
        ChangeRestaurantInfoPresenter changeRestaurantInfoPresenter = new ChangeRestaurantInfoProcessor(null);
        ChangeRestaurantInfoInputBoundary changeRestaurantInfoInputBoundary = new ChangeRestaurantInfoInteractor(changeRestaurantInfoPresenter);
        ChangeRestaurantInfoController changeRestaurantInfoController = new ChangeRestaurantInfoController(
                changeRestaurantInfoInputBoundary,
                restaurantProfileController.getCurrentRestaurantId());

        ChangeRestaurantInfoScreenInterface changeRestaurantInfoScreen = new ChangeRestaurantInfoScreen(changeRestaurantInfoController);

        changeRestaurantInfoPresenter.setScreen(changeRestaurantInfoScreen);

        changeRestaurantInfoScreen.getFrame().setVisible(true);
    }

    public void logout() {
        ShoppingCartSingleton.setSingletonInstance(new ShoppingCartSingleton(null, new HashMap<>()));
        OrderWatcherSingleton.getOrderWatcherSingletonInstance().getOrderWatcher().interrupt();

        java.awt.Window win[] = java.awt.Window.getWindows();
        for(int i=0;i<win.length;i++){
            win[i].dispose();
        }

        WelcomeScreen screen = new WelcomeScreen();
    }
}
