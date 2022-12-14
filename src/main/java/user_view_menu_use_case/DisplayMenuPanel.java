package user_view_menu_use_case;

import org.bson.types.ObjectId;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

public class DisplayMenuPanel extends JPanel implements DisplayMenuPanelInterface, ActionListener {

    private static final Color BG_DARK_GREEN = new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    private static final Border emptyBorder3 = BorderFactory.createEmptyBorder(0, 20, 0, 10);
    private static final Border blackLine = BorderFactory.createLineBorder(Color.black);

    private final DisplayMenuController controller;

    private final JLabel nameLabel = new JLabel();
    private final JLabel addLabel = new JLabel();
    private final JLabel phoneLabel = new JLabel();

    private final JPanel foodPanel = new JPanel();

    public DisplayMenuPanel(DisplayMenuController controller) {
        this.controller = controller;
        this.setLayout(new BorderLayout());

        JPanel resNamePanel = new JPanel(new GridLayout(1, 3));
        resNamePanel.setBorder(emptyBorder3);
        resNamePanel.setBackground(BG_DARK_GREEN);
        resNamePanel.setAlignmentX(CENTER_ALIGNMENT);

        nameLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
        nameLabel.setForeground(GREY_WHITE);
        nameLabel.setBorder(emptyBorder);
        resNamePanel.add(this.nameLabel);

        addLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 15));
        addLabel.setForeground(GREY_WHITE);
        addLabel.setBorder(emptyBorder);
        resNamePanel.add(this.addLabel);

        phoneLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 15));
        phoneLabel.setForeground(GREY_WHITE);
        phoneLabel.setBorder(emptyBorder);
        resNamePanel.add(this.phoneLabel);

        foodPanel.setBackground(GREY_WHITE);
        foodPanel.setBorder(blackLine);
        GridLayout layout = new GridLayout(0, 3);
        layout.setVgap(40);
        layout.setHgap(40);
        foodPanel.setLayout(layout);
        foodPanel.setBorder(emptyBorder);

        JPanel emptyPanel = new JPanel();
        emptyPanel.setBackground(BG_DARK_GREEN);
        emptyPanel.add(this.foodPanel);

        JScrollPane menuScroll = new JScrollPane(emptyPanel);
        menuScroll.setBorder(emptyBorder2);
        menuScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        menuScroll.setBackground(BG_DARK_GREEN);

        JPanel buttonPanel = new JPanel(new GridLayout(0, 1));
        buttonPanel.setBackground(BG_DARK_GREEN);
        buttonPanel.setBorder(emptyBorder);

        JButton finishButton = new JButton("Exit");
        finishButton.addActionListener(this);

        finishButton.setForeground(BG_DARK_GREEN);
        buttonPanel.add(finishButton);

        this.add(resNamePanel, BorderLayout.NORTH);
        this.add(menuScroll, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void updateNameLabel(String newName) {
        nameLabel.setText(newName);
    }


    /**
     * @param newAddress address of the res
     */
    @Override
    public void updateAddressLabel(String newAddress) {
        addLabel.setText("Address: " + newAddress);
    }

    /**
     * @param newPhone phone of the res
     */
    @Override
    public void updatePhoneLabel(String newPhone) {
        phoneLabel.setText("Phone: " + newPhone);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public void updateMenuPanel(HashMap<String, List> menuDic) {
        foodPanel.removeAll();

        for (int i = 0; i < menuDic.get("name").size(); i++) {

            JPanel f = new JPanel();
            f.setLayout(new GridLayout(0, 1));

            String food_name = menuDic.get("name").get(i).toString();
            String food_price = menuDic.get("price").get(i).toString();
            String food_category = menuDic.get("category").get(i).toString();
            String food_description = menuDic.get("description").get(i).toString();
            ObjectId foodId = new ObjectId(menuDic.get("id").get(i).toString());

            JLabel name = new JLabel("Name: " + food_name);
            JLabel price = new JLabel("Price: " + food_price);
            JLabel category = new JLabel("Category: " + food_category);
            JLabel description = new JLabel("Description: " + food_description);

            name.setForeground(BG_DARK_GREEN);
            price.setForeground(BG_DARK_GREEN);
            category.setForeground(BG_DARK_GREEN);
            description.setForeground(BG_DARK_GREEN);

            JButton addButton = new JButton("Add to cart");

            JPanel quantityPanel = new JPanel();
            quantityPanel.setBorder(emptyBorder2);
            quantityPanel.setForeground(BG_DARK_GREEN);
            quantityPanel.setLayout(new GridLayout(1, 2));

            JLabel quantityLabel = new JLabel("Enter Quantity: ");
            quantityLabel.setForeground(BG_DARK_GREEN);

            JTextField quantityField = new JTextField();
            quantityPanel.add(quantityLabel);
            quantityPanel.add(quantityField);
            addButton.addActionListener(new ActionListener() {
                /**
                 * calls the controller to add
                 * @param e the event to be processed
                 */
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.addItem(foodId, quantityField.getText());
                }
            });

            name.setBorder(emptyBorder2);
            description.setBorder(emptyBorder2);
            price.setBorder(emptyBorder2);
            category.setBorder(emptyBorder2);

            f.add(name);
            f.add(price);
            f.add(category);
            f.add(description);
            f.add(quantityPanel);
            f.add(addButton);

            foodPanel.add(f);
        }


    }

    /**
     * Updates the panel data
     */
    @Override
    public void updatePanelData() {
        controller.displayMenuPage();
    }

    /**
     * Performs the action associated with the button
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Exit")) {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.dispose();
        }
    }

}
