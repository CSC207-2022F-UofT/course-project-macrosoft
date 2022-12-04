package order_history_use_case;


import entities.Order;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OrderHistoryScreen extends JFrame{

    OrderHistoryController orderHistoryController;

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    private static final Border blackline = BorderFactory.createLineBorder(Color.black);

    public OrderHistoryScreen(OrderHistoryController controller){

        this.orderHistoryController = controller;

        JFrame frame = new JFrame("Order History");

        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100,800);
        frame.setLocationRelativeTo(null);

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(BG_DARK_GREEN);
        String orderTitle = controller.getOrderHistoryInput().getCurUser().getFirstName() + " " + controller.getOrderHistoryInput().getCurUser().getLastName() + "'s " +  "Order History";
        JLabel title = new JLabel(orderTitle);
        title.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        title.setForeground(GREY_WHITE);
        title.setBorder(emptyBorder);
        titlePanel.add(title);

        JPanel orderDisplayPanel = new JPanel();
        orderDisplayPanel.setBackground(GREY_WHITE);
        orderDisplayPanel.setBorder(blackline);
        GridLayout layout = new GridLayout(0 ,3);
        layout.setVgap(40);
        layout.setHgap(40);
        orderDisplayPanel.setLayout(layout);
        orderDisplayPanel.setBorder(emptyBorder);

        JScrollPane orderHistoryScroll = new JScrollPane(orderDisplayPanel);
        orderHistoryScroll.setBorder(emptyBorder2);
        orderHistoryScroll.setBackground(BG_DARK_GREEN);
        orderHistoryScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        title.setVerticalAlignment(JLabel.CENTER);

        List<Order> orderList = controller.getOrderHistoryInput().getOrders(new OrderHistoryRequestModel(controller.getOrderHistoryInput().getCurUser())).getOrders();
        for(Order order : orderList){
            JPanel orderPanel = new JPanel();
            orderPanel.setLayout(new GridLayout(0, 1));
            resIdToNameConvertor convertor = new resIdToNameConvertor();
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
                    OrderHistoryDetailScreen detailScreen = new OrderHistoryDetailScreen(controller, order);
                }
            });

            orderPanel.add(resName);
            orderPanel.add(orderTime);
            orderPanel.add(orderStatus);
            orderPanel.add(viewDetails);


            orderDisplayPanel.add(orderPanel);
        }


        frame.getContentPane().add(orderHistoryScroll, BorderLayout.CENTER);
        frame.getContentPane().add(titlePanel, BorderLayout.NORTH);

        frame.setVisible(true);
    }
}

