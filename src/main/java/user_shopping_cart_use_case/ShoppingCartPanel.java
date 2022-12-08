package user_shopping_cart_use_case;

import org.bson.types.ObjectId;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import static javax.swing.JOptionPane.showMessageDialog;

public class ShoppingCartPanel extends JPanel implements ShoppingCartPanelInterface {
    ShoppingCartController controller;
    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    JPanel shoppingCartPanel = new JPanel(new GridLayout(0, 3));

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(20, 20, 20, 20);

    JLabel title;

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

        title = new JLabel("Your Shopping is Empty");
        title.setBorder(emptyBorder2);
        title.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        title.setForeground(BG_DARK_GREEN);

        buttonPanel.add(title);
        buttonPanel.add(refreshButton);
        buttonPanel.add(checkoutButton);

        refreshButton.addActionListener(new ActionListener() {
            /**
             * call the controller to display shopping cart
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.displayShoppingCart();
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            /**
             * call the controller to check out
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.checkout();
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

    /**
     * @param message message to display
     */
    @Override
    public void showMessage(String message) {
        showMessageDialog(null, message);
    }

    public void displayShoppingCart(String restaurantName, HashMap<String, HashMap<String, Object>> cart) {
        if (restaurantName == null || cart.size() == 0) {
            title.setText("Your Shopping is Empty");
        }
        else {
            title.setText("Your Shopping Cart with " + restaurantName);
        }

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

            JLabel quantityLabel = new JLabel("Quantity: " + cart.get(foodName).get("quantity"));
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

            deleteButton.addActionListener(new ActionListener() {
                /**
                 * called the controller to delete an item
                 * @param e the event to be processed
                 */
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.deleteItem((ObjectId) cart.get(foodName).get("id"));
                    controller.displayShoppingCart();
                }
            });

            itemPanel.add(namePanel);
            itemPanel.add(quantityPanel);
            itemPanel.add(deleteButton);

            itemPanel.setBorder(emptyBorder2);

            this.shoppingCartPanel.add(itemPanel);
        }

        this.add(shoppingCartPanel);
        this.repaint();
        this.revalidate();
    }
}
