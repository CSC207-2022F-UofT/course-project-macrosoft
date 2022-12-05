package user_view_menu_use_case;
import menu_editing_use_case.*;
import menu_editing_use_case.Screens.AddFoodScreen;
import menu_editing_use_case.Screens.FoodEditingScreen;
import menu_editing_use_case.Screens.MenuScreen;
import org.bson.types.ObjectId;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

public class DisplayMenuPanel extends JPanel implements DisplayMenuPanelInterface, ActionListener{

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color BG_LIGHT_GREEN = new Color(87, 118, 83);
    private static final Color HL_LIGHT_GREEN = new Color(166, 199, 148);
    private static final Color HL_ORANGE_YELLOW = new Color(232, 181, 93);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    private static final Border blackLine = BorderFactory.createLineBorder(Color.black);

    private DisplayMenuController controller;

    private JLabel nameLabel = new JLabel();

    private JPanel foodPanel = new JPanel();

    public DisplayMenuPanel(DisplayMenuController controller) {
        this.controller = controller;
        this.setLayout(new BorderLayout());

        JPanel resNamePanel = new JPanel();
        resNamePanel.setBackground(BG_DARK_GREEN);

        nameLabel.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        nameLabel.setForeground(GREY_WHITE);
        nameLabel.setBorder(emptyBorder);
        resNamePanel.add(this.nameLabel);

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

    @Override
    public void updateMenuPanel(HashMap<String, List> menuDic) {
        foodPanel.removeAll();

        for(int i = 0; i< menuDic.get("name").size(); i++) {

            JPanel f = new JPanel();
            f.setLayout(new GridLayout(0, 1));

            String food_name = menuDic.get("name").get(i).toString();
            String food_price = menuDic.get("price").get(i).toString();
            String food_category = menuDic.get("category").get(i).toString();
            String food_description = menuDic.get("description").get(i).toString();

            JLabel name = new JLabel("Name: " + food_name);
            JLabel price = new JLabel("Price: " + food_price);
            JLabel category = new JLabel("Category: " + food_category);
            JLabel description = new JLabel("Description: " + food_description);

            JButton addButton = new JButton("Add to cart");
            addButton.addActionListener(this);

            JPanel quantityPanel = new JPanel();
            JLabel quantityLabel = new JLabel("Enter Quantity: ");
            JTextField quantityField = new JTextField();
            quantityPanel.setLayout(new GridLayout(1, 2));
            quantityPanel.add(quantityLabel);
            quantityPanel.add(quantityField);

            name.setBorder(emptyBorder2);
            name.setForeground(BG_DARK_GREEN);
            price.setBorder(emptyBorder2);
            price.setForeground(BG_DARK_GREEN);
            category.setBorder(emptyBorder2);
            category.setForeground(BG_DARK_GREEN);
            description.setBorder(emptyBorder2);
            description.setForeground(BG_DARK_GREEN);
            quantityPanel.setBorder(emptyBorder2);
            quantityPanel.setForeground(BG_DARK_GREEN);
            quantityLabel.setForeground(BG_DARK_GREEN);

            f.add(name);
            f.add(price);
            f.add(category);
            f.add(description);
            f.add(quantityPanel);
            f.add(addButton);


            foodPanel.add(f);
        }


    }

    @Override
    public void updatePanelData() {
        controller.displayMenuPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Exit")){
            this.removeAll();
        }
        else if (e.getActionCommand().equals("Add To cart")){

        }
    }

}
