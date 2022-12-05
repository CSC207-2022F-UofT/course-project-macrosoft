package update_order_status_use_case;

// Frameworks & Driver Layer

import update_order_status_use_case.UpdateOrderStatusController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.List;

public class UpdateOrderStatusScreen extends JFrame implements ActionListener{

    public final UpdateOrderStatusController updateOrderStatusController;

    private static final Border emptyBorder1 = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);


    public UpdateOrderStatusScreen(UpdateOrderStatusController controller) {
        this.updateOrderStatusController = controller;

        final JFrame frame = new JFrame();

        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JPanel ResNamePanel = new JPanel();

        JLabel label = new JLabel(controller.getStatusInput().getCurRes().getName());
        label.setFont(new Font("Serif", Font.PLAIN, 40));
        label.setBorder(emptyBorder1);
        ResNamePanel.add(label);

        JPanel orderPanel = new JPanel();
        JScrollPane ordersScroll = new JScrollPane(orderPanel);
        ordersScroll.setBorder(emptyBorder2);
        ordersScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        Border blackline = BorderFactory.createLineBorder(Color.black);
        orderPanel.setBorder(blackline);
        GridLayout layout = new GridLayout(0, 3);
        layout.setVgap(40);
        layout.setHgap(40);
        orderPanel.setLayout(layout);
        orderPanel.setBorder(emptyBorder1);

        HashMap<String, List> ordersDic = controller.getStatusInput().getOrderDic();

        for(int i = 0; i < ordersDic.get("_id").size(); i++) {

            JPanel panel = new JPanel();
            panel.setBackground(Color.BLUE); // change color
            panel.setLayout(new GridLayout(0, 1));

            JLabel orderId = new JLabel("Order Id: " + ordersDic.get("_id").get(i));
            JLabel orderTime = new JLabel("Order Time: " + ordersDic.get("orderTime").get(i));
            JLabel userId = new JLabel("User Id: " + ordersDic.get("userID").get(i));
            JLabel orderItems = new JLabel("Order Id: " + ordersDic.get("items").get(i));
            JComboBox orderStatus = new JComboBox();

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

            orderPanel.add(panel);


        }

        // JPanel buttonPanel = new JPanel(new GridLayout(0,2));
        // buttonPanel.setBorder(emptyBorder1);

        // JComboBox updatStatusBox = new JComboBox(controller.StatusInput.getOrders().);






    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}

