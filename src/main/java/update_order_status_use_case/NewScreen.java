package update_order_status_use_case;

import entities.Order;
import entities.OrderItem;
import update_order_status_use_case.NewController;
import order_history_use_case.resIdToNameConvertor;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

public class NewScreen {

    NewController controller;
    Order curOrder;

    private static final Color BG_DARK_GREEN = new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    private static final Border blackline = BorderFactory.createLineBorder(Color.black);

    public NewScreen(NewController controller, Order curOrder) {
        this.controller = controller;
        this.curOrder = curOrder;

        resIdToNameConvertor convertor = new resIdToNameConvertor();
        JFrame frame = new JFrame("Order details");

        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 800);
        frame.setLocationRelativeTo(null);

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(BG_DARK_GREEN);

        JLabel title = new JLabel(convertor.getResNameById(curOrder.getRestaurantID()));
        title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
        title.setForeground(GREY_WHITE);
        title.setBorder(emptyBorder);
        titlePanel.add(title);


        JPanel orderDisplayDetailPanel = new JPanel();
        orderDisplayDetailPanel.setBackground(GREY_WHITE);
        orderDisplayDetailPanel.setBorder(blackline);
        GridLayout layout = new GridLayout(0, 1);
        layout.setVgap(40);
        layout.setHgap(40);
        orderDisplayDetailPanel.setLayout(layout);
        orderDisplayDetailPanel.setBorder(emptyBorder);

        JScrollPane ordersScroll = new JScrollPane(orderDisplayDetailPanel);
        ordersScroll.setBorder(emptyBorder2);
        ordersScroll.setBackground(BG_DARK_GREEN);
        ordersScroll.setVerticalScrollBarPolicy((ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS));

        title.setVerticalAlignment(JLabel.CENTER);

        HashMap<String, List> ordersDic = controller.getOrderDic();

        for(int i = 0; i < ordersDic.get("_id").size(); i++) {

            JPanel panel = new JPanel();
            panel.setBackground(Color.BLUE); // change color
            panel.setLayout(new GridLayout(0, 1));

            JLabel orderId = new JLabel("Order Id: " + ordersDic.get("_id").get(i));
            JLabel orderTime = new JLabel("Order Time: " + ordersDic.get("orderTime").get(i));
            JLabel userId = new JLabel("User Id: " + ordersDic.get("userID").get(i));
            JLabel orderItems = new JLabel("Order Id: " + ordersDic.get("items").get(i));

            String[] status = {"Confirming Order", "Order Received", "Preparing", "Ready For Pickup", "Order Complete"};
            JComboBox orderStatus = new JComboBox(status);
            orderStatus.setSelectedIndex(0);

            orderStatus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });


            orderId.setBorder(emptyBorder2);
            orderTime.setBorder(emptyBorder2);
            userId.setBorder(emptyBorder2);
            orderItems.setBorder(emptyBorder2);
            orderStatus.setBorder(emptyBorder2);

            panel.add(orderId);
            panel.add(orderTime);
            panel.add(userId);
            panel.add(orderItems);
            panel.add(orderStatus);

            // orderStatus.addActionListener();

            orderDisplayDetailPanel.add(panel);
        }

        JPanel totalPanel = new JPanel();
        totalPanel.setBackground(BG_DARK_GREEN);


        JPanel right = new JPanel();
        JPanel left = new JPanel();

        right.setPreferredSize(new Dimension(100, 0));
        left.setPreferredSize(new Dimension(100, 0));
        right.setBackground(BG_DARK_GREEN);
        left.setBackground(BG_DARK_GREEN);

        frame.getContentPane().add(ordersScroll, BorderLayout.CENTER);
        frame.getContentPane().add(titlePanel, BorderLayout.NORTH);
        frame.getContentPane().add(totalPanel, BorderLayout.SOUTH);
        frame.getContentPane().add(right, BorderLayout.EAST);
        frame.getContentPane().add(left, BorderLayout.WEST);

        frame.setVisible(true);
    }

}
