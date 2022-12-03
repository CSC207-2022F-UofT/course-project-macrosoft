package menu_editing_use_case.Screens;

import menu_editing_use_case.MenuEditingController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFoodScreen {

    MenuEditingController menuEditingController;

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color BG_LIGHT_GREEN = new Color(87, 118, 83);
    private static final Color HL_LIGHT_GREEN = new Color(166, 199, 148);
    private static final Color HL_ORANGE_YELLOW = new Color(232, 181, 93);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Color WHITE = new Color(255, 255, 255);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);

    public AddFoodScreen(MenuEditingController controller){

        this.menuEditingController = controller;

        JFrame frame = new JFrame();

        frame.setSize(300, 500);
        frame.setLayout(new GridLayout(0, 1));

        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("Add Food Item");
        title.setFont(new Font("Serif", Font.PLAIN, 40));
        titlePanel.add(title);


        JPanel namePanel = new JPanel();
        JPanel descriptionPanel = new JPanel();
        JPanel categoryPanel = new JPanel();
        JPanel pricePanel = new JPanel();

        namePanel.setLayout(new GridLayout(1, 2));
        descriptionPanel.setLayout(new GridLayout(1, 2));
        categoryPanel.setLayout(new GridLayout(1, 2));
        pricePanel.setLayout(new GridLayout(1, 2));

        namePanel.setBorder(emptyBorder2);
        descriptionPanel.setBorder(emptyBorder2);
        categoryPanel.setBorder(emptyBorder2);
        pricePanel.setBorder(emptyBorder2);

        JLabel nameLabel = new JLabel("NAME");
        JLabel descriptionLabel = new JLabel("DESCRIPTION");
        JLabel categoryLabel = new JLabel("CATEGORY");
        JLabel priceLabel = new JLabel("PRICE");

        JTextField nameField = new JTextField();
        JTextField descriptionField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField priceField = new JTextField();

        namePanel.add(nameLabel);
        namePanel.add(nameField);
        descriptionPanel.add(descriptionLabel);
        descriptionPanel.add(descriptionField);
        categoryPanel.add(categoryLabel);
        categoryPanel.add(categoryField);
        pricePanel.add(priceLabel);
        pricePanel.add(priceField);

        JButton finishButton = new JButton("Add To Menu");
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuEditingController.create(nameField.getText(),
                        descriptionField.getText(),
                        categoryField.getText(),
                        Float.parseFloat(priceField.getText()));

                frame.dispose();
            }
        });

        frame.add(titlePanel);
        frame.add(namePanel);
        frame.add(categoryPanel);
        frame.add(descriptionPanel);
        frame.add(pricePanel);
        frame.add(finishButton);

        frame.setVisible(true);

    }
}
