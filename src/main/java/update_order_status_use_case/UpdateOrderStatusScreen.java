package update_order_status_use_case;

// Frameworks & Driver Layer

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class UpdateOrderStatusScreen extends JFrame implements UpdateOrderStatusScreenInterface, ActionListener {

    private final UpdateOrderStatusController controller;

    String[] orderStatus = {"Confirming Order", "Order Received", "Preparing Order", "Ready For Pickup",
            "Order Complete", "Order Cancelled"};

    private JComboBox comboBox = new JComboBox(orderStatus);

    public UpdateOrderStatusScreen(UpdateOrderStatusController controller) {
        this.controller = controller;

        JPanel panel = new JPanel();

        JLabel label = new JLabel("Order #" + controller.getOrderId());

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(comboBox);
        panel.add(label);

        this.add(panel, BorderLayout.CENTER);
        this.setTitle("Order Status");
        this.pack();

        comboBox.addActionListener(this);
    }

    @Override
    public void showMessage(String str) {
        showMessageDialog(null, str);
    }

    /**
     * @return
     */

    @Override
    public JFrame getFrame() {
        return this;
    }

    @Override
    public void close() {
        this.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        this.controller.updateOrderStatus(comboBox.getSelectedItem().toString());
    }
}
