package user_order_history_use_case;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class OrderHistoryDetailScreen {
    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    private static final Border blackline = BorderFactory.createLineBorder(Color.black);

    private final JLabel totalOrderPrice;

    JPanel orderDisplayDetailPanel;

    public OrderHistoryDetailScreen(ArrayList<HashMap<String, Object>> infos){


        JFrame frame = new JFrame("Order details");

        frame.setLayout(new BorderLayout());
        frame.setSize(900,700);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(BG_DARK_GREEN);

        JLabel title = new JLabel("Order Details");
        title.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        title.setForeground(GREY_WHITE);
        title.setBorder(emptyBorder);
        titlePanel.add(title);
        titlePanel.setBorder(emptyBorder);

        orderDisplayDetailPanel = new JPanel();
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
        orderHistoryDetailScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        title.setVerticalAlignment(JLabel.CENTER);

        JPanel totalPanel = new JPanel();
        totalPanel.setBackground(BG_DARK_GREEN);

        totalOrderPrice = new JLabel("Total: $" + 0.0);
        totalOrderPrice.setHorizontalTextPosition(JLabel.CENTER);
        totalOrderPrice.setForeground(GREY_WHITE);
        totalOrderPrice.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 30));
        totalPanel.add(totalOrderPrice);
        totalPanel.setBorder(emptyBorder);

        JPanel right = new JPanel();
        JPanel left = new JPanel();

        right.setPreferredSize(new Dimension(50 ,0));
        left.setPreferredSize(new Dimension(50 ,0));
        right.setBackground(BG_DARK_GREEN);
        left.setBackground(BG_DARK_GREEN);

        frame.getContentPane().add(orderHistoryDetailScroll, BorderLayout.CENTER);
        frame.getContentPane().add(titlePanel, BorderLayout.NORTH);
        frame.getContentPane().add(totalPanel, BorderLayout.SOUTH);
        frame.getContentPane().add(right, BorderLayout.EAST);
        frame.getContentPane().add(left, BorderLayout.WEST);

        displayOrderDetail(infos);

        frame.setVisible(true);
    }

    public void setTotal(double totalPrice) {
        totalOrderPrice.setText("Total: $" + totalPrice);
    }

    public void displayOrderDetail(ArrayList<HashMap<String, Object>> orderInfos) {
        orderDisplayDetailPanel.removeAll();

        double totalPrice = 0;

        for(HashMap<String, Object> info : orderInfos){
            JPanel foodPanel = new JPanel();
            foodPanel.setBackground(Color.lightGray);
            foodPanel.setLayout(new GridLayout(0, 1));
            JLabel foodName = new JLabel("Name: " + info.getOrDefault("name", ""));
            JLabel description = new JLabel("Description: " + info.getOrDefault("description", ""));
            JLabel category = new JLabel("Category: " + info.getOrDefault("category", ""));
            JLabel numOfItem = new JLabel("Number Of Items: " + info.getOrDefault("count", ""));
            double pricePerItem = (Float) info.getOrDefault("price", 0) * (Integer) info.getOrDefault("count", 0);
            JLabel pricePerFood = new JLabel("Price per Item: $" + info.getOrDefault("price", 0));
            JLabel price = new JLabel("Price In Total: $" + pricePerItem);
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

        setTotal(totalPrice);
    }
}
