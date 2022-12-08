package user_display_restaurants_use_case;

import components.ScreenFactory;
import org.bson.types.ObjectId;
import user_shopping_cart_use_case.ShoppingCartSingleton;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class RestaurantComponent extends JPanel {

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(10, 20, 10, 20);

    public RestaurantComponent(JLabel label, ObjectId restaurantId) {

        this.setLayout(new GridLayout(2, 1));
        this.setOpaque(true);
        this.setBackground(GREY_WHITE);
        this.setBorder(emptyBorder2);
        this.setPreferredSize(new Dimension(100, 200));

        JButton detailButton = new JButton("Detail");
        detailButton.setForeground(BG_DARK_GREEN);
        detailButton.setFont(new Font("Serif", Font.PLAIN, 15));

        detailButton.addActionListener(new ActionListener() {
            /**
             * creating a new menu screen
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenFactory screenFactory = new ScreenFactory();
                JPanel displayMenuPanel = screenFactory.createUserDisplayMenu(restaurantId);

                final JFrame frame = new JFrame();
                frame.setSize(900, 700);
                frame.setLocationRelativeTo(null);
                frame.add(displayMenuPanel);
                frame.setResizable(false);
                frame.setVisible(true);

                ShoppingCartSingleton.setSingletonInstance(new ShoppingCartSingleton(restaurantId, new HashMap<>()));
            }
        });

        this.add(label);
        this.add(detailButton);
    }
}
