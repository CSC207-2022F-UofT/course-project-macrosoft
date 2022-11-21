package UpdateOrderUseCase;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UpdateOrderStatusJFrame extends JFrame implements ActionListener {

    private JComboBox comboBox;

    public UpdateOrderStatusJFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        String[] OrderStatus = {"Order Received", "Preparing Order", "Ready For Pickup", "Order Complete"};
        // if you want a array of int or double, Integer[] and Double[] are used, Primitive data type

        comboBox = new JComboBox(OrderStatus);
        comboBox.addActionListener(this);

        // comboBox.setEditable(true); // to make choices editable.

        // System.out.println(comboBox.getItemCount()); // count number of choices

        // comboBox.addItem("\"); // add item to the box

        // comboBox.insertItemAt("\", 0);
        // its showing that the selection is dog at first, even though big is added at index 1,
        // so we need line 29 to let the system to always start at index 0

        // comboBox.setSelectedIndex(0); // its always going to select index 0 when the code start.

        // comboBox.removeItem("\"); // remove item cat

        // comboBox.removeItemAt(0); // remove item at index 0

        // comboBox.removeAllItems(); // remove all items in box

        this.add(comboBox);
        this.pack();
        this.setVisible(true);
        this.setTitle("Order Status");

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox) {
            System.out.println(comboBox.getSelectedItem()); // print out the selection by user
            // System.out.println(comboBox.getSelectedIndex()); // print out the index of selected choice
        }
    }


    public static void main(String[] args) {

        new UpdateOrderStatusJFrame();

    }
}

