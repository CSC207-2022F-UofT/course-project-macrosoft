package update_order_status_use_case;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Objects;

import static javax.swing.JOptionPane.showMessageDialog;

@SuppressWarnings("rawtypes")
public class UpdateOrderStatusScreen extends JFrame implements UpdateOrderStatusScreenInterface, ActionListener {

    String[] OrderStatus = {"Order Received", "Preparing Order", "Ready For Pickup", "Picked Up", "Order Complete", "Cancelled"};
    UpdateOrderStatusController updateOrderStatusController;

    public UpdateOrderStatusScreen(UpdateOrderStatusController updateOrderStatusController) {
        this.updateOrderStatusController = updateOrderStatusController;

        JPanel panel = new JPanel();

        JLabel label = new JLabel("Order #" + updateOrderStatusController.getCurrentOrderId());


        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        JComboBox<String> comboBox = new JComboBox<>(OrderStatus);
        panel.add(comboBox);
        panel.add(label);

        this.add(panel, BorderLayout.CENTER);
        this.setTitle("Order Status");
        this.pack();

        comboBox.addActionListener(this);
    }

    /**
     * update the status of the current by choices in the combo box
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();

        this.updateOrderStatusController.updateOrderStatus(Objects.requireNonNull(comboBox.getSelectedItem()).toString());
    }

    @Override
    public void showMessage(String message) {
        showMessageDialog(null, message);
    }

    /**
     * @return this frame
     */
    @Override
    public JFrame getFrame() {
        return this;
    }

    @Override
    public void close() {
        this.dispose();
    }
}
