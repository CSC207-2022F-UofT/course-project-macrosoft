package user_display_restaurants_use_case;

import login_use_case.*;
import org.bson.types.ObjectId;
import user_shopping_cart_use_case.ShoppingCartSingleton;
import user_view_menu_use_case.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class RestaurantComponent extends JPanel {

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color BG_LIGHT_GREEN = new Color(87, 118, 83);
    private static final Color HL_LIGHT_GREEN = new Color(166, 199, 148);
    private static final Color HL_ORANGE_YELLOW = new Color(232, 181, 93);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Color WHITE = new Color(255, 255, 255);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(10, 20, 10, 20);
    private static final Border blackline = BorderFactory.createLineBorder(Color.black);

    public RestaurantComponent(JLabel label, ObjectId restaurantId) {
        JButton detailButton = new JButton("Detail");
        detailButton.setForeground(BG_DARK_GREEN);
        detailButton.setFont(new Font("Serif", Font.PLAIN, 15));

        detailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayMenuPresenter presenter = new DisplayMenuProcessor(null);
                DisplayMenuInputBoundary interactor = new DisplayMenuInteractor(presenter);
                DisplayMenuController controller = new DisplayMenuController(interactor, restaurantId);

                final JFrame frame = new JFrame();
                frame.setSize(900, 700);
                frame.setLocationRelativeTo(null);

                DisplayMenuPanelInterface displayMenuPanel = new DisplayMenuPanel(controller);

                frame.add((JPanel)displayMenuPanel);

                presenter.setDisplayMenuPanel(displayMenuPanel);
                displayMenuPanel.updatePanelData();

                frame.setVisible(true);

                ShoppingCartSingleton.setSingletonInstance(new ShoppingCartSingleton(restaurantId, new HashMap<>()));
            }
        });

        this.setLayout(new GridLayout(3, 1));
        this.add(label);
        this.add(detailButton);
        this.setOpaque(true);
        this.setBackground(GREY_WHITE);
        this.setBorder(emptyBorder2);
    }
}
