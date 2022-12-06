package change_user_info_use_case;

import components.LabelTextPanel;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class ChangeUserInfoScreen extends JFrame implements ChangeUserInfoScreenInterface, ActionListener {
    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color BG_LIGHT_GREEN = new Color(87, 118, 83);
    private static final Color HL_LIGHT_GREEN = new Color(166, 199, 148);
    private static final Color HL_ORANGE_YELLOW = new Color(232, 181, 93);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Color WHITE = new Color(255, 255, 255);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(100, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    private static final Border blackline = BorderFactory.createLineBorder(Color.black);

    /**
     * The username chosen by the user
     */
    JTextField newFirstName = new JTextField(15);
    /**
     * The password
     */
    JTextField newLastName = new JTextField(15);
    /**
     * The password confirmation
     */
    JTextField newEmail = new JTextField(15);

    ChangeUserInfoController controller;

    public ChangeUserInfoScreen(ChangeUserInfoController controller) {
        this.controller = controller;

        this.setSize(900, 700);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(GREY_WHITE);

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(true);
        titlePanel.setBackground(GREY_WHITE);
        titlePanel.setBorder(emptyBorder);
        JLabel title = new JLabel("Change User Information");
        title.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        title.setForeground(BG_DARK_GREEN);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(title);

        JLabel firstLabel = new JLabel("New First Name");
        firstLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        firstLabel.setForeground(BG_DARK_GREEN);

        JLabel lastLabel = new JLabel("New Last Name");
        lastLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        lastLabel.setForeground(BG_DARK_GREEN);

        JLabel emailLabel = new JLabel("New Email");
        emailLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        emailLabel.setForeground(BG_DARK_GREEN);

        LabelTextPanel firstNameInfo = new LabelTextPanel(firstLabel, newFirstName);
        LabelTextPanel lastNameInfo = new LabelTextPanel(lastLabel, newLastName);
        LabelTextPanel emailInfo = new LabelTextPanel(emailLabel, newEmail);

        firstNameInfo.setOpaque(true);
        lastNameInfo.setOpaque(true);
        emailInfo.setOpaque(true);
        firstNameInfo.setBackground(GREY_WHITE);
        lastNameInfo.setBackground(GREY_WHITE);
        emailInfo.setBackground(GREY_WHITE);

        JButton save = new JButton("Save");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(save);
        buttons.add(cancel);
        buttons.setOpaque(true);
        buttons.setBackground(GREY_WHITE);

        save.addActionListener(this);
        cancel.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setOpaque(true);
        main.setBackground(GREY_WHITE);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(5, 1));
        infoPanel.add(firstNameInfo);
        infoPanel.add(lastNameInfo);
        infoPanel.add(emailInfo);
        infoPanel.setOpaque(false);

        main.add(titlePanel);
        main.add(infoPanel);
        main.add(buttons);
        this.setContentPane(main);

    }

    /**
     *
     */
    @Override
    public void close() {
        this.dispose();
    }

    /**
     * @param message
     */
    @Override
    public void showMessage(String message) {
        showMessageDialog(null, message);
    }

    /**
     * @return a JFrame object representation of self
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
                controller.changeUserInfo(
                        newFirstName.getText(),
                        newLastName.getText(),
                        newEmail.getText()
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
