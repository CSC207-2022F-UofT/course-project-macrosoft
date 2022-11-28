package UpdateOrderStatusUseCase;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class UpdateOrderStatusScreen implements ActionListener {

    String[] OrderStatus = {"Order Received", "Preparing Order", "Ready For Pickup", "Picked Up", "Order Complete"};
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel("Order #");
    private JComboBox comboBox = new JComboBox(OrderStatus);



    public UpdateOrderStatusScreen() {

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(comboBox);
        panel.add(label);



        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Order Status");
        frame.pack();
        frame.setVisible(true);

        comboBox.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // UpdateOrderStatusInteractor.updateOrderStatus( , );
    }



    public static void main(String[] args) {

        new UpdateOrderStatusScreen();

    }

}
