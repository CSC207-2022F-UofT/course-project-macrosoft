package restaurant_order_history_use_case;

import entities.Order;
import org.bson.types.ObjectId;
import update_order_status_use_case.*;
import user_make_review_use_case.MakeReviewController;
import user_make_review_use_case.screens.MakeReviewScreen;
import user_order_history_use_case.OrderHistoryController;
import user_order_history_use_case.OrderHistoryDetailScreen;
import user_order_history_use_case.OrderHistoryResponseModel;
import user_order_history_use_case.resIdToNameConvertor;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class RestaurantOrderHistoryPanel extends JPanel implements RestaurantOrderHistoryPanelInterface {

    RestaurantOrderHistoryController restaurantOrderHistoryController;

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    private static final Border blackline = BorderFactory.createLineBorder(Color.black);

    private JPanel orderDisplayPanel = new JPanel();

    public RestaurantOrderHistoryPanel(RestaurantOrderHistoryController controller, String restaurantName){

        this.restaurantOrderHistoryController = controller;


        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(BG_DARK_GREEN);
        String orderTitle = restaurantName + "'s Order History";

        JLabel title = new JLabel(orderTitle);
        title.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
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

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restaurantOrderHistoryController.getOrders();
            }
        });

        showCurrentOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restaurantOrderHistoryController.getUnfufilledOrders();
            }
        });

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

        JLabel orderHistory = new JLabel();
        orderHistory.setText("You do not have any order history");
        orderHistory.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 60));
        orderDisplayPanel.add(orderHistory);

        JPanel right = new JPanel();
        JPanel left = new JPanel();
        JPanel bottom = new JPanel();

        right.setPreferredSize(new Dimension(50 ,0));
        left.setPreferredSize(new Dimension(50 ,0));
        bottom.setPreferredSize(new Dimension(0 ,100));
        right.setBackground(BG_DARK_GREEN);
        left.setBackground(BG_DARK_GREEN);
        bottom.setBackground(BG_DARK_GREEN);

        this.setLayout(new BorderLayout());
        this.add(orderHistoryScroll, BorderLayout.CENTER);
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(right, BorderLayout.EAST);
        this.add(left, BorderLayout.WEST);
        this.add(bottom, BorderLayout.SOUTH);
    }

    @Override
    public void setOrder(ArrayList<HashMap<String, Object>> orderInfos) {
        orderDisplayPanel.removeAll();

        for(HashMap<String, Object> orderInfo : orderInfos){
            JPanel orderPanel = new JPanel();
            orderPanel.setLayout(new GridLayout(0, 1));
            resIdToNameConvertor convertor = new resIdToNameConvertor();
            JLabel orderId = new JLabel("ID: " + orderInfo.get("ID"));
            JLabel userName = new JLabel("User Name: " + orderInfo.get("Name"));
            JLabel orderTime = new JLabel("Order Time: " + orderInfo.get("Time"));
            JLabel orderStatus = new JLabel("Order Status: " + orderInfo.get("Status"));
            JButton viewDetails = new JButton("View Details");
            JButton setStatus = new JButton("Set Status");

            viewDetails.setForeground(BG_DARK_GREEN);

            orderId.setForeground(BG_DARK_GREEN);
            orderId.setBorder(emptyBorder2);
            userName.setForeground(BG_DARK_GREEN);
            userName.setBorder(emptyBorder2);
            orderTime.setForeground(BG_DARK_GREEN);
            orderTime.setBorder(emptyBorder2);
            orderStatus.setForeground(BG_DARK_GREEN);
            orderStatus.setBorder(emptyBorder2);

            viewDetails.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            setStatus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showEditOrderStatusScreen((ObjectId) orderInfo.get("ID"));
                }
            });

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
        UpdateOrderStatusPresenter orderStatusPresenter = new UpdateOrderStatusProcessor(null);
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
}
