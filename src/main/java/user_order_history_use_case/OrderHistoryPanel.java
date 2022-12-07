package user_order_history_use_case;

import components.ScreenFactory;
import org.bson.types.ObjectId;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class OrderHistoryPanel extends JPanel implements OrderHistoryPanelInterface{

    OrderHistoryController orderHistoryController;

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    private static final Border blackLine = BorderFactory.createLineBorder(Color.black);

    private final JPanel orderDisplayPanel = new JPanel();

    @SuppressWarnings("Unchecked")
    public OrderHistoryPanel(OrderHistoryController controller){

        this.orderHistoryController = controller;


        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(BG_DARK_GREEN);
        String orderTitle = "Order History";

        JLabel title = new JLabel(orderTitle);
        title.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        title.setForeground(GREY_WHITE);
        title.setBorder(emptyBorder);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.setOpaque(false);
        refreshButton.setForeground(BG_DARK_GREEN);

        JButton filterButton = new JButton("Show Current Orders");
        filterButton.setOpaque(false);
        filterButton.setForeground(BG_DARK_GREEN);

        titlePanel.add(title);
        titlePanel.add(refreshButton);
        titlePanel.add(filterButton);

        refreshButton.addActionListener(e -> orderHistoryController.getOrders());

        filterButton.addActionListener(e -> orderHistoryController.getCurrentOrder());

        orderDisplayPanel.setBackground(GREY_WHITE);
        orderDisplayPanel.setBorder(blackLine);
        GridLayout layout = new GridLayout(0 ,2);
        layout.setVgap(40);
        layout.setHgap(40);
        orderDisplayPanel.setLayout(layout);
        orderDisplayPanel.setBorder(emptyBorder);

        JScrollPane orderHistoryScroll = new JScrollPane(orderDisplayPanel);
        orderHistoryScroll.setBorder(emptyBorder2);
        orderHistoryScroll.setBackground(BG_DARK_GREEN);
        orderHistoryScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        title.setVerticalAlignment(JLabel.CENTER);

        JLabel orderHistory = new JLabel();
        orderHistory.setText("You do not have any order history");
        orderHistory.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 60));
        orderDisplayPanel.add(orderHistory);


        this.setLayout(new BorderLayout());
        this.add(orderHistoryScroll, BorderLayout.CENTER);
        this.add(titlePanel, BorderLayout.NORTH);
    }

    /**
     * set the order panel
     * @param orderHistoryResponseModel response model
     */
    @SuppressWarnings("unchecked")
    @Override
    public void setOrder(OrderHistoryResponseModel orderHistoryResponseModel) {
        orderDisplayPanel.removeAll();

        for(HashMap<String, Object> order : orderHistoryResponseModel.getOrders()){
            JPanel orderPanel = new JPanel();
            orderPanel.setLayout(new GridLayout(0, 1));
            JLabel id = new JLabel("ID: " + order.get("orderId"));
            JLabel resName = new JLabel("Restaurant Name: " + order.get("restaurantName"));
            JLabel orderTime = new JLabel("Order Time: " + order.get("orderTime"));
            JLabel orderStatus = new JLabel("Order Status: " + order.get("orderStatus"));
            JButton viewDetails = new JButton("View Details");
            JButton makeReview = new JButton("Make Review");

            viewDetails.setForeground(BG_DARK_GREEN);
            id.setForeground(BG_DARK_GREEN);
            resName.setForeground(BG_DARK_GREEN);
            orderTime.setForeground(BG_DARK_GREEN);
            orderStatus.setForeground(BG_DARK_GREEN);

            id.setBorder(emptyBorder2);
            resName.setBorder(emptyBorder2);
            orderTime.setBorder(emptyBorder2);
            orderStatus.setBorder(emptyBorder2);

            viewDetails.addActionListener(e -> new OrderHistoryDetailScreen((ArrayList<HashMap<String, Object>>) order.get("orderItems")));

            makeReview.addActionListener(e -> {
                ScreenFactory screenFactory = new ScreenFactory();
                screenFactory.createMakeReviewScreen((ObjectId) order.get("orderId"));
            });

            orderPanel.add(id);
            orderPanel.add(resName);
            orderPanel.add(orderTime);
            orderPanel.add(orderStatus);
            orderPanel.add(viewDetails);
            orderPanel.add(makeReview);


            orderDisplayPanel.add(orderPanel);
        }

        orderDisplayPanel.revalidate();
        orderDisplayPanel.repaint();
    }

    @Override
    public void updateOrder() {
        orderHistoryController.getOrders();
    }
}

