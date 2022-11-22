package OrderHistoryUseCase;

import javax.swing.*;
import java.awt.*;

public class OrderHistoryScreen extends JFrame{

    public static void OrderHistoryScreen(){

        JFrame frame = new JFrame("Order History");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setVisible(true);


        JLabel Title = new JLabel();
        Title.setText("Order History");

        JPanel titlePanel = new JPanel();
        JPanel orderDisplayPanel = new JPanel();
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JPanel btmPanel = new JPanel();

        titlePanel.setPreferredSize(new Dimension(100, 70));
        orderDisplayPanel.setPreferredSize(new Dimension(100, 100));
        leftPanel.setPreferredSize(new Dimension(100, 100));
        rightPanel.setPreferredSize(new Dimension(100, 100));
        btmPanel.setPreferredSize(new Dimension(100, 100));

        titlePanel.add(Title);
        Title.setVerticalAlignment(JLabel.CENTER);

        orderDisplayPanel.setBackground(Color.lightGray);



        frame.add(orderDisplayPanel, BorderLayout.CENTER);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(btmPanel, BorderLayout.SOUTH);

    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                OrderHistoryScreen();
            }
        });
    }
}

