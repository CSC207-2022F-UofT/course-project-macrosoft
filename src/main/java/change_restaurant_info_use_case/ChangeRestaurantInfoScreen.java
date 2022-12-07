package change_restaurant_info_use_case;


import components.LabelTextPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class ChangeRestaurantInfoScreen extends JFrame implements ChangeRestaurantInfoScreenInterface, ActionListener {

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color BG_LIGHT_GREEN = new Color(87, 118, 83);
    private static final Color HL_LIGHT_GREEN = new Color(166, 199, 148);
    private static final Color HL_ORANGE_YELLOW = new Color(232, 181, 93);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Color WHITE = new Color(255, 255, 255);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(100, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    private static final Border blackline = BorderFactory.createLineBorder(Color.black);
    JTextField newName = new JTextField(15);
    JTextField newEmail = new JTextField(15);
    JTextField newLocation = new JTextField(15);
    JTextField newPhone = new JTextField(15);

    ChangeRestaurantInfoController controller;

    public ChangeRestaurantInfoScreen(ChangeRestaurantInfoController controller){
        this.controller = controller;

        this.setSize(900, 700);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(GREY_WHITE);

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(true);
        titlePanel.setBackground(GREY_WHITE);
        titlePanel.setBorder(emptyBorder);
        JLabel title = new JLabel("Change Restaurant Information");
        title.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        title.setForeground(BG_DARK_GREEN);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(title);

        JLabel nameLabel = new JLabel("New Name");
        nameLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        nameLabel.setForeground(BG_DARK_GREEN);

        JLabel emailLabel = new JLabel("New Email");
        emailLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        emailLabel.setForeground(BG_DARK_GREEN);

        JLabel locationLabel = new JLabel("New Location");
        locationLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        locationLabel.setForeground(BG_DARK_GREEN);

        JLabel phoneLabel = new JLabel("New Phone Number");
        phoneLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        phoneLabel.setForeground(BG_DARK_GREEN);

        LabelTextPanel nameInfo = new LabelTextPanel(nameLabel, newName);
        LabelTextPanel emailInfo = new LabelTextPanel(emailLabel, newEmail);
        LabelTextPanel locationInfo = new LabelTextPanel(locationLabel, newLocation);
        LabelTextPanel phoneInfo = new LabelTextPanel(phoneLabel, newPhone);

        nameInfo.setOpaque(true);
        emailInfo.setOpaque(true);
        locationInfo.setOpaque(true);
        phoneInfo.setOpaque(true);
        nameInfo.setBackground(GREY_WHITE);
        emailInfo.setBackground(GREY_WHITE);
        locationInfo.setBackground(GREY_WHITE);
        phoneInfo.setBackground(GREY_WHITE);

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
        infoPanel.add(nameInfo);
        infoPanel.add(emailInfo);
        infoPanel.add(locationInfo);
        infoPanel.add(phoneInfo);

        infoPanel.setOpaque(false);

        main.add(titlePanel);
        main.add(infoPanel);
        main.add(buttons);
        this.setContentPane(main);
    }


    @Override
    public void close() {
        this.dispose();
    }

    @Override
    public void showMessage(String message) {
        showMessageDialog(null, message);
    }

    @Override
    public JFrame getFrame() {
        return this;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Save")) {
            try {
                controller.changeRestaurantInfo(
                        newName.getText(),
                        newEmail.getText(),
                        newLocation.getText(),
                        newPhone.getText()
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
