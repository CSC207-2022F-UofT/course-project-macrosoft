package user_order_history_use_case;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * The class for order history detail screen
 */
public class OrderHistoryDetailScreen {
    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    private static final Border blackline = BorderFactory.createLineBorder(Color.black);

    private JLabel totalOrderPrice;

    JPanel orderDisplayDetailPanel;

    /**
     * A window with all the ordered food displayed in single panel respectively along with the total price for the order
     * @param infos A list of all the info needed for each ordered food, including name, price per item/ price in total, category, description and number of items
     */
    public OrderHistoryDetailScreen(ArrayList<HashMap<String, Object>> infos){


        JFrame frame = new JFrame("Order details");

        frame.setLayout(new BorderLayout());
        frame.setSize(900,700);
        frame.setLocationRelativeTo(null);

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(BG_DARK_GREEN);

        JLabel title = new JLabel();
        title.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        title.setForeground(GREY_WHITE);
        title.setBorder(emptyBorder);
        titlePanel.add(title);


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

        title.setVerticalAlignment(JLabel.CENTER);

        JPanel totalPanel = new JPanel();
        totalPanel.setBackground(BG_DARK_GREEN);

        totalOrderPrice = new JLabel("Total: $" + 0.0);
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

        displayOrderDetail(infos);

        frame.setVisible(true);
    }

    /**
     * Set the total price for each order
     *
     * @param totalPrice the total price for each order
     */
    public void setTotal(double totalPrice) {
        totalOrderPrice.setText("Total: $" + totalPrice);
    }


    /**
     * Display the order details, including name, price per item/ price in total, category, description and number of items
     *
     * @param orderInfos A list of info needed for each item, including name, price per item/ price in total, category, description and number of items
     */
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
