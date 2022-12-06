package user_shopping_cart_use_case;

import entities.Order;
import order_history_use_case.OrderHistoryController;
import order_history_use_case.OrderHistoryDetailScreen;
import order_history_use_case.resIdToNameConvertor;
import org.bson.types.ObjectId;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingCartPanel extends JPanel implements ShoppingCartPanelInterface{

    ShoppingCartController controller;

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    private static final Border blackline = BorderFactory.createLineBorder(Color.black);

    private JPanel shoppingCartDisplayPanel = new JPanel();

    public ShoppingCartPanel(ShoppingCartController controller) {

        this.controller = controller;


        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(BG_DARK_GREEN);
        JLabel title = new JLabel("Shopping Cart");
        title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
        title.setForeground(GREY_WHITE);
        title.setBorder(emptyBorder);
        titlePanel.add(title);

        shoppingCartDisplayPanel.setBackground(GREY_WHITE);
        shoppingCartDisplayPanel.setBorder(blackline);
        GridLayout layout = new GridLayout(0, 3);
        layout.setVgap(40);
        layout.setHgap(40);
        shoppingCartDisplayPanel.setLayout(layout);
        shoppingCartDisplayPanel.setBorder(emptyBorder);

        JScrollPane shoppingCartScoll = new JScrollPane(shoppingCartDisplayPanel);
        shoppingCartScoll.setBorder(emptyBorder2);
        shoppingCartScoll.setBackground(BG_DARK_GREEN);
        shoppingCartScoll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        title.setVerticalAlignment(JLabel.CENTER);

        JLabel shoppingCart = new JLabel();
        shoppingCart.setText("You do not have any items in the shopping cart yet");
        shoppingCart.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 60));
        shoppingCartDisplayPanel.add(shoppingCart);

        JPanel right = new JPanel();
        JPanel left = new JPanel();
        JPanel bottom = new JPanel();

        right.setPreferredSize(new Dimension(50, 0));
        left.setPreferredSize(new Dimension(50, 0));
        bottom.setPreferredSize(new Dimension(0, 100));
        right.setBackground(BG_DARK_GREEN);
        left.setBackground(BG_DARK_GREEN);
        bottom.setBackground(BG_DARK_GREEN);

        this.setLayout(new BorderLayout());
        this.add(shoppingCartScoll, BorderLayout.CENTER);
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(right, BorderLayout.EAST);
        this.add(left, BorderLayout.WEST);
        this.add(bottom, BorderLayout.SOUTH);
    }

    @Override
    public void setShippingCart(ShoppingCartResponseModel responseModel) {
        shoppingCartDisplayPanel.removeAll();
        for(ObjectId foodId : responseModel.getCartSingleton().getCart().keySet()){
            JPanel orderPanel = new JPanel();
            orderPanel.setLayout(new GridLayout(0, 1));
            JLabel resName = new JLabel("Restaurant Name: " + convertor.getResNameById(order.getRestaurantID()));
            JLabel orderTime = new JLabel("Order Time: " + order.getOrderDate());
            JLabel orderStatus = new JLabel("Order Status: " + order.getOrderStatus());
            JButton viewDetails = new JButton("View Details");

            viewDetails.setForeground(BG_DARK_GREEN);

            resName.setForeground(BG_DARK_GREEN);
            resName.setBorder(emptyBorder2);
            orderTime.setForeground(BG_DARK_GREEN);
            orderTime.setBorder(emptyBorder2);
            orderStatus.setForeground(BG_DARK_GREEN);
            orderStatus.setBorder(emptyBorder2);

            viewDetails.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    OrderHistoryDetailScreen detailScreen = new OrderHistoryDetailScreen(orderHistoryController, order);
                }
            });

            orderPanel.add(resName);
            orderPanel.add(orderTime);
            orderPanel.add(orderStatus);
            orderPanel.add(viewDetails);


            orderDisplayPanel.add(orderPanel);
    }


    @Override
    public void updateShoppingCart() {

    }
}
