package OrderHistoryUseCase;


import Entities.Order;
import Entities.OrderItem;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class OrderHistoryScreen extends JFrame{

    OrderHistoryController orderHistoryController;
    public OrderHistoryScreen(OrderHistoryController controller){

        this.orderHistoryController = controller;

        JFrame frame = new JFrame("Order History");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);


        String orderTitle = controller.getOrderHistoryInput().getCurUser().getFirstName() + " " + controller.getOrderHistoryInput().getCurUser().getLastName() + "'s " +  "Order History";
        JLabel title = new JLabel(orderTitle);
        title.setFont(new Font("Serif", Font.PLAIN, 40));
        title.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));


        JPanel titlePanel = new JPanel();
        JPanel orderDisplayPanel = new JPanel();
        JScrollPane orderHistoryScroll = new JScrollPane(orderDisplayPanel);
        orderHistoryScroll.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        orderHistoryScroll.setVerticalScrollBarPolicy((ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS));
        orderDisplayPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        titlePanel.add(title);
        title.setVerticalAlignment(JLabel.CENTER);

        orderDisplayPanel.setBackground(Color.lightGray);

        GridLayout layout = new GridLayout(0 ,3);
        layout.setVgap(40);
        layout.setHgap(40);
        orderDisplayPanel.setLayout(layout);

        List<Order> orderList = controller.getOrderHistoryInput().getOrders(new OrderHistoryRequestModel(controller.getOrderHistoryInput().getCurUser())).getOrders();
        for(Order order : orderList){
            JPanel orderPanel = new JPanel();
            orderPanel.setBackground(new Color(214, 210, 205));
            orderPanel.setLayout(new GridLayout(0, 1));
            resIdToNameConvertor convertor = new resIdToNameConvertor();
            JLabel resName = new JLabel("Restaurant Name: " + convertor.getResNameById(order.getRestaurantID()));
            String orderFoods = "";
            for (OrderItem orderItem : order.getItems()) {
                if(orderItem.getFood() != null){
                    String foodName = orderItem.getFood().getName();
                    String foodNum = String.valueOf(orderItem.getNumberOfItem());
                    orderFoods = orderFoods + foodName + " # " + foodNum + "\n";
                }
            }
            JLabel orderItems = new JLabel("Order Items: " + orderFoods);
            JLabel orderTime = new JLabel("Order Time: " + order.getOrderDate());
            JLabel orderStatus = new JLabel("Order Status: " + order.getOrderStatus());


            orderPanel.add(resName);
            orderPanel.add(orderItems);
            orderPanel.add(orderTime);
            orderPanel.add(orderStatus);

            orderDisplayPanel.add(orderPanel);
        }
        frame.getContentPane().add(orderDisplayPanel, BorderLayout.CENTER);
        frame.getContentPane().add(titlePanel, BorderLayout.NORTH);

        frame.setVisible(true);
    }
}

