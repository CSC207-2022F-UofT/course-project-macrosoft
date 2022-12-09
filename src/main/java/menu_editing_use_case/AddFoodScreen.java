package menu_editing_use_case;

import menu_editing_use_case.MenuEditingController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFoodScreen {

    MenuEditingController menuEditingController;

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(5, 15, 5, 15);
    private static final Border emptyBorder3 = BorderFactory.createEmptyBorder(20, 0, 0, 0);

    public AddFoodScreen(MenuEditingController controller){
        // initialize the controller
        this.menuEditingController = controller;

        // create a new window
        JFrame frame = new JFrame();
        frame.setSize(300, 500);
        frame.setLayout(new GridLayout(0, 1));
        frame.setResizable(false);

        // initialize and set size & dimension of a title panel
        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("Add Food Item");
        title.setFont(new Font("Serif", Font.PLAIN, 40));
        title.setForeground(GREY_WHITE);
        titlePanel.add(title);
        titlePanel.setOpaque(true);
        titlePanel.setBorder(emptyBorder3);
        titlePanel.setBackground(BG_DARK_GREEN);

        // name, description, category, price panel
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

        //text field for users to enter information
        JTextField nameField = new JTextField();
        JTextField descriptionField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField priceField = new JTextField();

        //add the text field to panels
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        descriptionPanel.add(descriptionLabel);
        descriptionPanel.add(descriptionField);
        categoryPanel.add(categoryLabel);
        categoryPanel.add(categoryField);
        pricePanel.add(priceLabel);
        pricePanel.add(priceField);

        // create a button panel.
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(true);
        buttonPanel.setBackground(BG_DARK_GREEN);
        buttonPanel.setBorder(emptyBorder3);

        JButton finishButton = new JButton("Add To Menu");
        finishButton.setOpaque(true);
        finishButton.setBackground(BG_DARK_GREEN);

        // adding action listener to the finish button
        finishButton.addActionListener(new ActionListener() {
            /**
             * calls the menu editing controller to add a new food with given information.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                menuEditingController.add(nameField.getText(),
                        descriptionField.getText(),
                        categoryField.getText(),
                        Float.parseFloat(priceField.getText()));
                // close the frame after done
                frame.dispose();
            }
        });

        // add finish button to the panel
        buttonPanel.add(finishButton);

        // add everything to the frame
        frame.add(titlePanel);
        frame.add(namePanel);
        frame.add(categoryPanel);
        frame.add(descriptionPanel);
        frame.add(pricePanel);
        frame.add(buttonPanel);

        frame.setVisible(true);

    }
}
