package change_password_use_case;

import components.LabelTextPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

// Frameworks/Drivers layer

public class ChangePasswordScreen extends JFrame implements ChangePasswordScreenInterface, ActionListener {


    /**
     * Color and border variables.
     */

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Border emptyBorder = BorderFactory.createEmptyBorder(100, 30, 30, 30);


    /**
     * The username chosen by the user
     */
    JTextField originalPassword = new JTextField(15);
    /**
     * The password
     */
    JPasswordField newPassword = new JPasswordField(15);
    /**
     * The password confirmation
     */
    JPasswordField confirmNewPassword = new JPasswordField(15);

    private ChangePasswordController changePasswordController;

    public ChangePasswordScreen(ChangePasswordController controller) {

        // Initialize the controller
        this.changePasswordController = controller;

        // Set the position and size of the screen
        this.setSize(900, 700);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //Background color of the screen
        this.getContentPane().setBackground(GREY_WHITE);

        // Panel that contains the title
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(true);
        titlePanel.setBackground(GREY_WHITE);
        titlePanel.setBorder(emptyBorder);
        JLabel title = new JLabel("Change Password");
        title.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        title.setForeground(BG_DARK_GREEN);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(title);

        //Username label
        JLabel username = new JLabel("Original Password");
        username.setFont(new Font("Serif", Font.PLAIN, 15));
        username.setForeground(BG_DARK_GREEN);

        // password label
        JLabel password = new JLabel("New Password");
        password.setFont(new Font("Serif", Font.PLAIN, 15));
        password.setForeground(BG_DARK_GREEN);

        // confirm new password label
        JLabel confirm = new JLabel("Confirm New Password");
        confirm.setFont(new Font("Serif", Font.PLAIN, 15));
        confirm.setForeground(BG_DARK_GREEN);

        //text field for user to enter information, use the previously designed labels as guide
        LabelTextPanel usernameInfo = new LabelTextPanel(username, originalPassword);
        LabelTextPanel passwordInfo = new LabelTextPanel(password, newPassword);
        LabelTextPanel confirmPasswordInfo = new LabelTextPanel(confirm, confirmNewPassword);

        // design and format of the panels
        usernameInfo.setOpaque(true);
        passwordInfo.setOpaque(true);
        confirmPasswordInfo.setOpaque(true);
        usernameInfo.setBackground(GREY_WHITE);
        passwordInfo.setBackground(GREY_WHITE);
        confirmPasswordInfo.setBackground(GREY_WHITE);

        // action buttons
        JButton save = new JButton("Save");
        JButton cancel = new JButton("Cancel");

        // button panel
        JPanel buttons = new JPanel();
        buttons.add(save);
        buttons.add(cancel);
        buttons.setOpaque(true);
        buttons.setBackground(GREY_WHITE);

        // add action listener to the buttons
        save.addActionListener(this);
        cancel.addActionListener(this);

        //main content panel
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setOpaque(true);
        main.setBackground(GREY_WHITE);

        //panels that contains all components except the title and buttons
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(5, 1));
        infoPanel.add(usernameInfo);
        infoPanel.add(passwordInfo);
        infoPanel.add(confirmPasswordInfo);
        infoPanel.setOpaque(false);

        // add everything to the main panel
        main.add(titlePanel);
        main.add(infoPanel);
        main.add(buttons);
        this.setContentPane(main);
    }

    /**
     * Close this frame
     */
    @Override
    public void close(){
        this.dispose();
    }

    /**
     * Displays a prompt message box with
     * @param message the message to be displayed in the prompt
     */
    @Override
    public void showMessage(String message) {
        showMessageDialog(null, message);
    }

    /**
     * @return the JFrame representation of this object
     */
    @Override
    public JFrame getFrame() {
        return this;
    }

    /**
     * @param evt the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Save")) {
            try {
                changePasswordController.changePassword(
                        originalPassword.getText(),
                        String.valueOf(newPassword.getPassword()),
                        String.valueOf(confirmNewPassword.getPassword())
                );
            } catch (Exception e) {
                showMessageDialog(this, e.getMessage());
            }
        }
        else if (evt.getActionCommand().equals("Cancel")) {
            this.close();
        }
    }
}
