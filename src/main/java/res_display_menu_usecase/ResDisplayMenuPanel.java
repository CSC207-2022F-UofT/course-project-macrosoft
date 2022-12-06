package res_display_menu_usecase;

import menu_editing_use_case.*;
import menu_editing_use_case.Screens.AddFoodScreen;
import menu_editing_use_case.Screens.FoodEditingScreen;
import org.bson.types.ObjectId;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

public class ResDisplayMenuPanel extends JPanel implements ResDisplayMenuPanelInterface, ActionListener{

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color BG_LIGHT_GREEN = new Color(87, 118, 83);
    private static final Color HL_LIGHT_GREEN = new Color(166, 199, 148);
    private static final Color HL_ORANGE_YELLOW = new Color(232, 181, 93);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    private static final Border blackLine = BorderFactory.createLineBorder(Color.black);

    private ResDisplayMenuController controller;

    private JLabel nameLabel = new JLabel();

    private JPanel foodPanel = new JPanel();

    public ResDisplayMenuPanel(ResDisplayMenuController controller) {
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

        JPanel buttonPanel = new JPanel(new GridLayout(0, 2));
        buttonPanel.setBackground(BG_DARK_GREEN);
        buttonPanel.setBorder(emptyBorder);

        JButton addFoodButton = new JButton("Add Item");
        JButton refreshButton = new JButton("Refresh");
        addFoodButton.addActionListener(this);
        refreshButton.addActionListener(this);

        addFoodButton.setForeground(BG_DARK_GREEN);
        addFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AddFoodInputBoundary interactor_add = new MenuEditingInteractor(controller.getRestId());
                RemoveFoodInputBoundary interactor_remove = new MenuEditingInteractor(controller.getRestId());
                MenuEditingController controller1 = new MenuEditingController(interactor_add, interactor_remove, controller.getRestId());

                AddFoodScreen screen = new AddFoodScreen(controller1);
            }
        });
        refreshButton.setForeground(BG_DARK_GREEN);
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.displayMenuPage();
            }
        });

        buttonPanel.add(addFoodButton);
        buttonPanel.add(refreshButton);

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
            ObjectId foodId = new ObjectId(menuDic.get("id").get(i).toString());

            JLabel name = new JLabel("Name: " + food_name);
            JLabel price = new JLabel("Price: " + food_price);
            JLabel category = new JLabel("Category: " + food_category);
            JLabel description = new JLabel("Description: " + food_description);

            JButton delete = new JButton("Delete");
            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AddFoodInputBoundary interactor_add = new MenuEditingInteractor(controller.getRestId());
                    RemoveFoodInputBoundary interactor_remove = new MenuEditingInteractor(controller.getRestId());
                    MenuEditingController controller1 = new MenuEditingController(interactor_add, interactor_remove, controller.getRestId());

                    controller1.remove(foodId);
                }
            });

            JButton edit = new JButton("Edit");
            edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AddFoodInputBoundary interactor_add = new MenuEditingInteractor(controller.getRestId());
                    RemoveFoodInputBoundary interactor_remove = new MenuEditingInteractor(controller.getRestId());
                    MenuEditingController controller1 = new MenuEditingController(interactor_add, interactor_remove, controller.getRestId());

                    FoodEditingScreen screen = new FoodEditingScreen(controller1, food_name, food_category, food_description, food_price, foodId);
                }
            });

            delete.setForeground(BG_DARK_GREEN);
            edit.setForeground(BG_DARK_GREEN);

            name.setBorder(emptyBorder2);
            name.setForeground(BG_DARK_GREEN);
            price.setBorder(emptyBorder2);
            price.setForeground(BG_DARK_GREEN);
            category.setBorder(emptyBorder2);
            category.setForeground(BG_DARK_GREEN);
            description.setBorder(emptyBorder2);
            description.setForeground(BG_DARK_GREEN);

            f.add(name);
            f.add(price);
            f.add(category);
            f.add(description);
            f.add(delete);
            f.add(edit);

            foodPanel.add(f);
        }
    }

    @Override
    public void updatePanelData() {
        controller.displayMenuPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
