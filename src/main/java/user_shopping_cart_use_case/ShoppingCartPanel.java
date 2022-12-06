package user_shopping_cart_use_case;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ShoppingCartPanel extends JPanel implements ShoppingCartPanelInterface {
    ShoppingCartController controller;
    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    JPanel shoppingCartPanel = new JPanel(new GridLayout(0, 3));

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color BG_LIGHT_GREEN = new Color(87, 118, 83);
    private static final Color HL_LIGHT_GREEN = new Color(166, 199, 148);
    private static final Color HL_ORANGE_YELLOW = new Color(232, 181, 93);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Color WHITE = new Color(255, 255, 255);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(20, 20, 20, 20);
    private static final Border blackline = BorderFactory.createLineBorder(Color.black);

    public ShoppingCartPanel(ShoppingCartController controller) {
        this.controller = controller;

        this.setLayout(new BorderLayout());
        this.setBorder(emptyBorder);
        this.setOpaque(true);
        this.setBackground(GREY_WHITE);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(true);
        buttonPanel.setBackground(GREY_WHITE);
        buttonPanel.setBorder(emptyBorder);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.setOpaque(false);
        refreshButton.setForeground(BG_DARK_GREEN);

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.setOpaque(false);
        checkoutButton.setForeground(BG_DARK_GREEN);

        JLabel title = new JLabel("Your Shopping Cart");
        title.setBorder(emptyBorder2);
        title.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        title.setForeground(BG_DARK_GREEN);

        buttonPanel.add(title);
        buttonPanel.add(refreshButton);
        buttonPanel.add(checkoutButton);

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.displayShoppingCart();
            }
        });



        shoppingCartPanel.setOpaque(true);
        shoppingCartPanel.setBackground(GREY_WHITE);
        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(shoppingCartPanel, BorderLayout.CENTER);
    }

    public void refreshData() {
        controller.displayShoppingCart();
    }

    public void displayShoppingCart(HashMap<String, Integer> cart) {
        this.remove(shoppingCartPanel);
        this.shoppingCartPanel = new JPanel(new GridLayout(0, 3));
        this.shoppingCartPanel.setOpaque(true);
        this.shoppingCartPanel.setBackground(GREY_WHITE);

        for (String foodName: cart.keySet()) {
            JPanel itemPanel = new JPanel();
            itemPanel.setOpaque(true);
            itemPanel.setBackground(GREY_WHITE);
            itemPanel.setBorder(emptyBorder2);

            itemPanel.setLayout(new GridLayout(3, 1));

            JLabel foodNameLabel = new JLabel("Name: " + foodName);
            foodNameLabel.setFont(new Font("Serif", Font.PLAIN, 15));
            foodNameLabel.setForeground(BG_DARK_GREEN);

            JLabel quantityLabel = new JLabel("Quantity: " + String.valueOf(cart.get(foodName)));
            quantityLabel.setFont(new Font("Serif", Font.PLAIN, 15));
            quantityLabel.setForeground(BG_DARK_GREEN);

            JPanel namePanel = new JPanel();
            JPanel quantityPanel = new JPanel();
            namePanel.add(foodNameLabel);
            quantityPanel.add(quantityLabel);
            namePanel.setAlignmentX(LEFT_ALIGNMENT);
            quantityPanel.setAlignmentX(LEFT_ALIGNMENT);
            namePanel.setOpaque(false);
            quantityPanel.setOpaque(false);

            JButton deleteButton = new JButton("Delete");

            itemPanel.add(namePanel);
            itemPanel.add(quantityPanel);
            itemPanel.add(deleteButton);

            itemPanel.setBorder(emptyBorder2);

            this.shoppingCartPanel.add(itemPanel);
        }

        this.add(shoppingCartPanel);
        this.repaint();
    }
}
