package restaurant_order_history_use_case;

import org.bson.types.ObjectId;
import update_order_status_use_case.*;
import user_order_history_use_case.OrderHistoryDetailScreen;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import static javax.swing.JOptionPane.showMessageDialog;

public class RestaurantOrderHistoryPanel extends JPanel implements RestaurantOrderHistoryPanelInterface {

    RestaurantOrderHistoryController restaurantOrderHistoryController;

    private static final Color BG_DARK_GREEN = new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    private static final Border blackline = BorderFactory.createLineBorder(Color.black);

    private final JPanel orderDisplayPanel = new JPanel();

    public RestaurantOrderHistoryPanel(RestaurantOrderHistoryController controller, String restaurantName) {

        this.restaurantOrderHistoryController = controller;

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(BG_DARK_GREEN);
        String orderTitle = restaurantName + "'s Order History";

        JLabel title = new JLabel(orderTitle);
        title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
        title.setForeground(GREY_WHITE);
        title.setBorder(emptyBorder);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.setOpaque(false);
        refreshButton.setForeground(BG_DARK_GREEN);

        JButton showCurrentOrdersButton = new JButton("Show Current Orders");
        showCurrentOrdersButton.setOpaque(false);
        showCurrentOrdersButton.setForeground(BG_DARK_GREEN);

        titlePanel.add(title);
        titlePanel.add(refreshButton);
        titlePanel.add(showCurrentOrdersButton);

        refreshButton.addActionListener(e -> restaurantOrderHistoryController.getOrders());

        showCurrentOrdersButton.addActionListener(e -> restaurantOrderHistoryController.getUnfufilledOrders());

        orderDisplayPanel.setBackground(GREY_WHITE);
        orderDisplayPanel.setBorder(blackline);
        GridLayout layout = new GridLayout(0, 2);
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
        orderHistory.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 60));
        orderDisplayPanel.add(orderHistory);

        this.setLayout(new BorderLayout());
        this.add(orderHistoryScroll, BorderLayout.CENTER);
        this.add(titlePanel, BorderLayout.NORTH);
    }

    @Override
    public void setOrder(ArrayList<HashMap<String, Object>> orderInfos) {
        orderDisplayPanel.removeAll();

        for (HashMap<String, Object> orderInfo : orderInfos) {
            JPanel orderPanel = new JPanel();
            orderPanel.setLayout(new GridLayout(0, 1));
            JLabel orderId = new JLabel("ID: " + orderInfo.get("ID"));
            JLabel userName = new JLabel("User Name: " + orderInfo.get("Name"));
            JLabel orderTime = new JLabel("Order Time: " + orderInfo.get("Time"));
            JLabel orderStatus = new JLabel("Order Status: " + orderInfo.get("Status"));
            JButton viewDetails = new JButton("View Details");
            JButton setStatus = new JButton("Set Status");
            viewDetails.setForeground(BG_DARK_GREEN);
            setStatus.setForeground(BG_DARK_GREEN);

            viewDetails.setForeground(BG_DARK_GREEN);

            orderId.setForeground(BG_DARK_GREEN);
            orderId.setBorder(emptyBorder2);
            userName.setForeground(BG_DARK_GREEN);
            userName.setBorder(emptyBorder2);
            orderTime.setForeground(BG_DARK_GREEN);
            orderTime.setBorder(emptyBorder2);
            orderStatus.setForeground(BG_DARK_GREEN);
            orderStatus.setBorder(emptyBorder2);

            viewDetails.addActionListener(e -> new OrderHistoryDetailScreen((ArrayList<HashMap<String, Object>>) orderInfo.get("OrderItems")));

            setStatus.addActionListener(e -> showEditOrderStatusScreen((ObjectId) orderInfo.get("ID")));

            orderPanel.add(orderId);
            orderPanel.add(userName);
            orderPanel.add(orderTime);
            orderPanel.add(orderStatus);
            orderPanel.add(viewDetails);
            orderPanel.add(setStatus);


            orderDisplayPanel.add(orderPanel);
        }

        orderDisplayPanel.revalidate();
        orderDisplayPanel.repaint();
    }

    public void showEditOrderStatusScreen(ObjectId orderId) {
        UpdateOrderStatusOutputBoundary orderStatusPresenter = new UpdateOrderStatusPresenter(null);
        UpdateOrderStatusInputBoundary orderStatusInteractor = new UpdateOrderStatusInteractor(orderStatusPresenter);
        UpdateOrderStatusController orderStatusController = new UpdateOrderStatusController(orderStatusInteractor, orderId);
        UpdateOrderStatusScreenInterface screen = new UpdateOrderStatusScreen(orderStatusController);

        orderStatusPresenter.setScreen(screen);
        screen.getFrame().setVisible(true);
    }

    @Override
    public void updateOrder() {
        restaurantOrderHistoryController.getOrders();
    }

    /**
     * @param message result message
     */
    @Override
    public void showMessage(String message) {
        showMessageDialog(null, message);
    }
}
