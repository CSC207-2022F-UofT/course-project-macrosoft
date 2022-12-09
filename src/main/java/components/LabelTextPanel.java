package components;

import javax.swing.*;

// Frameworks/Drivers layer

public class LabelTextPanel extends JPanel {
    /**
     * The label
     */
    public LabelTextPanel(JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
    }
}