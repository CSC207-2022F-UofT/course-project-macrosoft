package menu_editing_use_case.Screens;

import menu_editing_use_case.MenuEditingController;
import org.bson.types.ObjectId;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodEditingScreen {
    MenuEditingController controller;

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color BG_LIGHT_GREEN = new Color(87, 118, 83);
    private static final Color HL_LIGHT_GREEN = new Color(166, 199, 148);
    private static final Color HL_ORANGE_YELLOW = new Color(232, 181, 93);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Color WHITE = new Color(255, 255, 255);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(10, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(5, 15, 5, 15);
    private static final Border emptyBorder3 = BorderFactory.createEmptyBorder(20, 0, 0, 0);

    public FoodEditingScreen(MenuEditingController controller, String name, String category, String description, String price, ObjectId id) {

        this.controller = controller;
        JFrame frame = new JFrame();

        frame.setSize(300, 500);
        frame.setLayout(new GridLayout(0, 1));

        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("Edit Food Item");
        title.setFont(new Font("Serif", Font.ITALIC|Font.BOLD, 35));
        title.setForeground(GREY_WHITE);
        titlePanel.add(title);
        titlePanel.setOpaque(true);
        titlePanel.setBorder(emptyBorder3);
        titlePanel.setBackground(BG_DARK_GREEN);

        JPanel namePanel = new JPanel();
        JPanel descriptionPanel = new JPanel();
        JPanel categoryPanel = new JPanel();
        JPanel pricePanel = new JPanel();

        namePanel.setOpaque(true);
        descriptionPanel.setOpaque(true);
        categoryPanel.setOpaque(true);
        pricePanel.setOpaque(true);

        namePanel.setBackground(BG_DARK_GREEN);
        descriptionPanel.setBackground(BG_DARK_GREEN);
        categoryPanel.setBackground(BG_DARK_GREEN);
        pricePanel.setBackground(BG_DARK_GREEN);

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

        nameLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        descriptionLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        categoryLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        priceLabel.setFont(new Font("Serif", Font.PLAIN, 15));

        nameLabel.setForeground(GREY_WHITE);
        descriptionLabel.setForeground(GREY_WHITE);
        categoryLabel.setForeground(GREY_WHITE);
        priceLabel.setForeground(GREY_WHITE);

        JTextField nameField = new JTextField(name);
        JTextField descriptionField = new JTextField(description);
        JTextField categoryField = new JTextField(category);
        JTextField priceField = new JTextField(price);

        namePanel.add(nameLabel);
        namePanel.add(nameField);
        descriptionPanel.add(descriptionLabel);
        descriptionPanel.add(descriptionField);
        categoryPanel.add(categoryLabel);
        categoryPanel.add(categoryField);
        pricePanel.add(priceLabel);
        pricePanel.add(priceField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(true);
        buttonPanel.setBackground(BG_DARK_GREEN);
        buttonPanel.setBorder(emptyBorder3);

        JButton finishButton = new JButton("Submit Change");
        finishButton.setOpaque(true);
        finishButton.setBackground(BG_DARK_GREEN);

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.add(name, description, category, Float.parseFloat(price));
                controller.remove(id);
                frame.dispose();
            }
        });

        buttonPanel.add(finishButton);

        frame.add(titlePanel);
        frame.add(namePanel);
        frame.add(categoryPanel);
        frame.add(descriptionPanel);
        frame.add(pricePanel);
        frame.add(buttonPanel);

        frame.setVisible(true);
    }
}
