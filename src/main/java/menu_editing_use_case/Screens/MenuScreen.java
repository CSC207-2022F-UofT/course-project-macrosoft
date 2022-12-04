package menu_editing_use_case.Screens;

//Frameworks & Drivers Layer

import menu_editing_use_case.MenuEditingController;
import menu_editing_use_case.MenuEditingPresenter;
import org.bson.types.ObjectId;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

public class MenuScreen extends JFrame implements ActionListener{

    MenuEditingController menuEditingController;
    MenuEditingPresenter menuEditingPresenter;

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color BG_LIGHT_GREEN = new Color(87, 118, 83);
    private static final Color HL_LIGHT_GREEN = new Color(166, 199, 148);
    private static final Color HL_ORANGE_YELLOW = new Color(232, 181, 93);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Color WHITE = new Color(255, 255, 255);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    private static final Border blackLine = BorderFactory.createLineBorder(Color.black);

//    private JPanel menuPanel;

    public MenuScreen(MenuEditingController controller, MenuEditingPresenter presenter){

        this.menuEditingController = controller;
        this.menuEditingPresenter = presenter;

        final JFrame frame = new JFrame();

        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JPanel resNamePanel = new JPanel();
        resNamePanel.setBackground(BG_DARK_GREEN);

        JLabel label = new JLabel(controller.getAdd_input().getCurRes().getName());
        label.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));

        label.setForeground(GREY_WHITE);
        label.setBorder(emptyBorder);
        resNamePanel.add(label);

        JPanel menuPanel = getMenuPanel(controller);

        JPanel emptyPanel = new JPanel();
        emptyPanel.setBackground(BG_DARK_GREEN);
        emptyPanel.add(menuPanel);

        JScrollPane menuScroll = new JScrollPane(emptyPanel);
        menuScroll.setBorder(emptyBorder2);
        menuScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        menuScroll.setBackground(BG_DARK_GREEN);

        JPanel buttonPanel = new JPanel(new GridLayout(0, 3));
        buttonPanel.setBackground(BG_DARK_GREEN);
        buttonPanel.setBorder(emptyBorder);

        JButton addFoodButton = new JButton("Add Item");
        JButton finishButton = new JButton("Finish");
        JButton refreshButton = new JButton("Refresh");

        addFoodButton.setForeground(BG_DARK_GREEN);
        finishButton.setForeground(BG_DARK_GREEN);
        refreshButton.setForeground(BG_DARK_GREEN);

        addFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddFoodScreen foodScreen = new AddFoodScreen(controller, menuPanel);
            }
        });

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyPanel.removeAll();
                JPanel newMenuPanel = getMenuPanel(controller);
                emptyPanel.add(newMenuPanel);

            }
        });

        buttonPanel.add(addFoodButton);
        buttonPanel.add(finishButton);
        buttonPanel.add(refreshButton);

        frame.getContentPane().add(resNamePanel, BorderLayout.NORTH);
        frame.getContentPane().add(menuScroll, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public JPanel getMenuPanel(MenuEditingController controller){

        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(GREY_WHITE);
        menuPanel.setBorder(blackLine);
        GridLayout layout = new GridLayout(0, 3);
        layout.setVgap(40);
        layout.setHgap(40);
        menuPanel.setLayout(layout);
        menuPanel.setBorder(emptyBorder);

        HashMap<String, List> menuDic = menuEditingController.getAdd_input().getMenuDic();


        for(int i = 0; i< menuDic.get("name").size(); i++){

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

            JButton delete = new JButton("Delete");
            JButton edit = new JButton("Edit");

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

            ObjectId curid = new ObjectId(menuDic.get("id").get(i).toString());

            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    menuEditingController.create(curid);
                }
            });

            edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    FoodEditingScreen screen = new FoodEditingScreen(controller, food_name, food_category, food_description, food_price, curid);
                }
            });

            f.add(name);
            f.add(price);
            f.add(category);
            f.add(description);
            f.add(delete);
            f.add(edit);

            menuPanel.add(f);

        }
        return menuPanel;
    }
    public void actionPerformed(ActionEvent e){

    }
}
