package order_history_use_case;

import entities.Order;
import entities.OrderItem;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class OrderHistoryDetailScreen {
    OrderHistoryController controller;
    Order curOrder;

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    private static final Border blackline = BorderFactory.createLineBorder(Color.black);

    public OrderHistoryDetailScreen (OrderHistoryController controller, Order curOrder){
        this.controller = controller;
        this.curOrder = curOrder;


        resIdToNameConvertor convertor = new resIdToNameConvertor();
        JFrame frame = new JFrame("Order details");

        frame.setLayout(new BorderLayout());
        frame.setSize(900,700);
        frame.setLocationRelativeTo(null);

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(BG_DARK_GREEN);

        JLabel title = new JLabel(convertor.getResNameById(curOrder.getRestaurantID()));
        title.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        title.setForeground(GREY_WHITE);
        title.setBorder(emptyBorder);
        titlePanel.add(title);


        JPanel orderDisplayDetailPanel = new JPanel();
        orderDisplayDetailPanel.setBackground(GREY_WHITE);
        orderDisplayDetailPanel.setBorder(blackline);
        GridLayout layout = new GridLayout(0 ,3);
        layout.setVgap(40);
        layout.setHgap(40);
        orderDisplayDetailPanel.setLayout(layout);
        orderDisplayDetailPanel.setBorder(emptyBorder);

        JScrollPane orderHistoryDetailScroll = new JScrollPane(orderDisplayDetailPanel);
        orderHistoryDetailScroll.setBorder(emptyBorder2);
        orderHistoryDetailScroll.setBackground(BG_DARK_GREEN);
        orderHistoryDetailScroll.setVerticalScrollBarPolicy((ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS));

        title.setVerticalAlignment(JLabel.CENTER);


        double totalPrice = 0;
        for(OrderItem orderItem : curOrder.getItems()){
            JPanel foodPanel = new JPanel();
            foodPanel.setBackground(Color.lightGray);
            foodPanel.setLayout(new GridLayout(0, 1));
            JLabel foodName = new JLabel("Name: " + orderItem.getFood().getName());
            JLabel description = new JLabel("Description: " + orderItem.getFood().getDescription());
            JLabel category = new JLabel("Category: " + orderItem.getFood().getCategory());
            JLabel numOfItem = new JLabel("Number Of Items: " + String.valueOf(orderItem.getNumberOfItem()));
            double pricePerItem = orderItem.getFood().getPrice() * orderItem.getNumberOfItem();
            JLabel pricePerFood = new JLabel("Price per Item: $" + String.valueOf(orderItem.getFood().getPrice()));
            JLabel price = new JLabel("Price In Total: $" + String.valueOf(pricePerItem));
            totalPrice += pricePerItem;

            foodName.setForeground(BG_DARK_GREEN);
            foodName.setBorder(emptyBorder2);
            description.setForeground(BG_DARK_GREEN);
            description.setBorder(emptyBorder2);
            category.setForeground(BG_DARK_GREEN);
            category.setBorder(emptyBorder2);
            numOfItem.setForeground(BG_DARK_GREEN);
            numOfItem.setBorder(emptyBorder2);
            pricePerFood.setForeground(BG_DARK_GREEN);
            pricePerFood.setBorder(emptyBorder2);
            price.setForeground(BG_DARK_GREEN);
            price.setBorder(emptyBorder2);


            foodPanel.add(foodName);
            foodPanel.add(description);
            foodPanel.add(category);
            foodPanel.add(numOfItem);
            foodPanel.add(pricePerFood);
            foodPanel.add(price);


            orderDisplayDetailPanel.add(foodPanel);
        }

        JPanel totalPanel = new JPanel();
        totalPanel.setBackground(BG_DARK_GREEN);

        JLabel totalOrderPrice = new JLabel("Total: $" + String.valueOf(totalPrice));
        totalOrderPrice.setHorizontalTextPosition(JLabel.CENTER);
        totalOrderPrice.setForeground(GREY_WHITE);
        totalOrderPrice.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        totalPanel.add(totalOrderPrice);

        JPanel right = new JPanel();
        JPanel left = new JPanel();
        JPanel bottom = new JPanel();

        right.setPreferredSize(new Dimension(50 ,0));
        left.setPreferredSize(new Dimension(50 ,0));
        right.setBackground(BG_DARK_GREEN);
        left.setBackground(BG_DARK_GREEN);

        frame.getContentPane().add(orderHistoryDetailScroll, BorderLayout.CENTER);
        frame.getContentPane().add(titlePanel, BorderLayout.NORTH);
        frame.getContentPane().add(totalPanel, BorderLayout.SOUTH);
        frame.getContentPane().add(right, BorderLayout.EAST);
        frame.getContentPane().add(left, BorderLayout.WEST);

        frame.setVisible(true);
    }
}
