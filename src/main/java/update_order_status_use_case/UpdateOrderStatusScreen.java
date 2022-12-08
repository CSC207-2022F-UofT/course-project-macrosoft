package update_order_status_use_case;

// Frameworks & Driver Layer

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * This is the screen that extends JFrame, and implementes UpdateOrderStatusScreenInterface, ActionListener.
 */
public class UpdateOrderStatusScreen extends JFrame implements UpdateOrderStatusScreenInterface, ActionListener {

    private final UpdateOrderStatusController controller;

    /**
     * Array of Strings, including all order status.
     */
    String[] orderStatus = {"Confirming Order", "Order Received", "Preparing Order", "Ready For Pickup",
            "Order Complete", "Order Cancelled"};

    /**
     * The combobox with all order status as choices.
     */
    private JComboBox comboBox = new JComboBox(orderStatus);

    /**
     * Constructor of UpdateOrderStatusScreen
     *
     * @param controller UpdateOrderStatusController current order controller
     */
    public UpdateOrderStatusScreen(UpdateOrderStatusController controller) {

        //initialize the controller
        this.controller = controller;

        // create a new panel, and a new label with order id.
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Order #" + controller.getOrderId());

        // set border and layout of the panel
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));

        // add the combobox and label to the panel
        panel.add(comboBox);
        panel.add(label);

        // add the panel to the screen and set its title
        this.add(panel, BorderLayout.CENTER);
        this.setTitle("Order Status");
        this.setLocationRelativeTo(null);
        this.pack();

        comboBox.addActionListener(this);
    }

    /**
     * This method override the same method in screen interface.
     * Show message on the screen.
     *
     * @param str String message
     */
    @Override
    public void showMessage(String str) {
        showMessageDialog(null, str);
    }

    /**
     * This method override the same method in screen interface.
     * Get current frame
     *
     * @return JFrame current frame
     */
    @Override
    public JFrame getFrame() {
        return this;
    }

    /**
     * This method override the same method in screen interface.
     * Close the screen
     */
    @Override
    public void close() {
        this.dispose();
    }

    /**
     * This method override the same method in screen interface.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        String status = comboBox.getSelectedItem().toString();
        this.controller.updateOrderStatus(status);
    }
}
