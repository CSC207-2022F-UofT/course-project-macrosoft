package res_display_menu_usecase;

import components.ScreenFactory;
import menu_editing_use_case.MenuEditingController;
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
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    private static final Border blackLine = BorderFactory.createLineBorder(Color.black);

    final private ResDisplayMenuController controller;
    final private MenuEditingController menuEditingController;

    final private JLabel nameLabel = new JLabel();

    final private JPanel foodPanel = new JPanel();

    public ResDisplayMenuPanel(ResDisplayMenuController controller, MenuEditingController menuEditingController) {
        this.controller = controller;
        this.menuEditingController = menuEditingController;

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
            /**
             * initialize a new add food screen
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ScreenFactory screenFactory = new ScreenFactory();
                screenFactory.createAddFoodScreen(controller.getRestId());
            }
        });
        refreshButton.setForeground(BG_DARK_GREEN);
        refreshButton.addActionListener(new ActionListener() {
            /**
             * update the menu panel
             * @param e the event to be processed
             */
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
    @SuppressWarnings("rawtypes")
    public void updateMenuPanel(HashMap<String, List> menuDic) {

        foodPanel.removeAll();

        for(int i = 0; i< menuDic.get("name").size(); i++) {

            JPanel f = new JPanel();
            f.setLayout(new GridLayout(0, 1));


            JButton delete = new JButton("Delete");

            String foodCategory = menuDic.get("category").get(i).toString();
            String foodDescription = menuDic.get("description").get(i).toString();
            String foodName = menuDic.get("name").get(i).toString();
            String foodPrice = menuDic.get("price").get(i).toString();
            ObjectId foodId = new ObjectId(menuDic.get("id").get(i).toString());

            delete.addActionListener(new ActionListener() {
                /**
                 * calls the controller to remove the current food
                 * @param e the event to be processed
                 */
                @Override
                public void actionPerformed(ActionEvent e) {
                    menuEditingController.remove(foodId);
                    controller.displayMenuPage();
                }
            });

            JButton edit = new JButton("Edit");
            edit.addActionListener(new ActionListener() {
                /**
                 * initialize a new food editing screen
                 * @param e the event to be processed
                 */
                @Override
                public void actionPerformed(ActionEvent e) {
                    ScreenFactory screenFactory = new ScreenFactory();
                    screenFactory.createFoodEditingScreen(controller.getRestId(), foodName, foodCategory, foodDescription, foodPrice, foodId);
                }
            });

            JLabel name = new JLabel("Name: " + foodName);
            JLabel price = new JLabel("Price: " + foodPrice);
            JLabel category = new JLabel("Category: " + foodCategory);
            JLabel description = new JLabel("Description: " + foodDescription);

            name.setBorder(emptyBorder2);
            price.setBorder(emptyBorder2);
            category.setBorder(emptyBorder2);
            description.setBorder(emptyBorder2);

            delete.setForeground(BG_DARK_GREEN);
            edit.setForeground(BG_DARK_GREEN);

            name.setForeground(BG_DARK_GREEN);
            price.setForeground(BG_DARK_GREEN);
            category.setForeground(BG_DARK_GREEN);
            description.setForeground(BG_DARK_GREEN);

            f.add(name);
            f.add(price);
            f.add(category);
            f.add(description);
            f.add(delete);
            f.add(edit);

            foodPanel.add(f);
        }

        foodPanel.repaint();
        foodPanel.revalidate();
    }

    @Override
    public void updatePanelData() {
        controller.displayMenuPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
