package user_shopping_cart_use_case;

import login_use_case.*;

import javax.swing.*;
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
    JPanel shoppingCartPanel = new JPanel(new GridLayout(0, 1));

    public ShoppingCartPanel(ShoppingCartController controller) {
        this.controller = controller;

        this.setLayout(new GridLayout(0, 1));

        JButton refreshButton = new JButton("Update");

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.displayShoppingCart();
            }
        });

        this.add(refreshButton);
        this.add(shoppingCartPanel);
    }

    public void refreshData() {
        controller.displayShoppingCart();
    }

    public void displayShoppingCart(HashMap<String, Integer> cart) {
        this.shoppingCartPanel = new JPanel(new GridLayout(0, 1));

        for (String foodName: cart.keySet()) {
            JPanel itemPanel = new JPanel();
            itemPanel.add(new JLabel(foodName));
            itemPanel.add(new JLabel(String.valueOf(cart.get(foodName))));

            JButton deleteButton = new JButton("Delete");
            itemPanel.add(deleteButton);

            this.shoppingCartPanel.add(itemPanel);
        }

        this.add(shoppingCartPanel);
    }
}
