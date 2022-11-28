package MenuEditingUseCase.Screens;

//Frameworks & Drivers Layer

import MenuEditingUseCase.MenuEditingController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.List;

public class MenuScreen extends JFrame implements ActionListener{

    MenuEditingController menuEditingController;

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color BG_LIGHT_GREEN = new Color(87, 118, 83);
    private static final Color HL_LIGHT_GREEN = new Color(166, 199, 148);
    private static final Color HL_ORANGE_YELLOW = new Color(232, 181, 93);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Color WHITE = new Color(255, 255, 255);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);

    public MenuScreen(MenuEditingController controller){

        this.menuEditingController = controller;

        final JFrame frame = new JFrame();

        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JPanel resNamePanel = new JPanel();
        JLabel label = new JLabel(controller.getAdd_input().getCurRes().getName());
        label.setFont(new Font("Serif", Font.PLAIN, 40));
        label.setBorder(emptyBorder);
        resNamePanel.add(label);

        JPanel menuPanel = new JPanel();
        Border blackline = BorderFactory.createLineBorder(Color.black);
        menuPanel.setBorder(blackline);
        GridLayout layout = new GridLayout(0, 3);
        layout.setVgap(40);
        layout.setHgap(40);
        menuPanel.setLayout(layout);
        menuPanel.setBorder(emptyBorder);

//        Entities.Menu curMenu = controller.getAdd_input().getMenu();
        HashMap<String, List> menuDic = controller.getAdd_input().getMenuDic();

//        for(Food curFood: curMenu.getFoodList()) {
//            JPanel f = new JPanel();
//            f.setBackground(GREY_WHITE);
//            f.setLayout(new GridLayout(0, 1));
//
//            JLabel name = new JLabel("Name: " + curFood.getName());
//            JLabel price = new JLabel("Price: " + Float.toString(curFood.getPrice()));
//            JLabel category = new JLabel("Category: " + curFood.getCategory());
//            JLabel description = new JLabel("Description: " + curFood.getDescription());
//            JButton delete = new JButton("Delete");
//            JButton edit = new JButton("Edit");
//
//            name.setBorder(emptyBorder2);
//            price.setBorder(emptyBorder2);
//            category.setBorder(emptyBorder2);
//            description.setBorder(emptyBorder2);
//
//            f.add(name);
//            f.add(price);
//            f.add(category);
//            f.add(description);
//            f.add(delete);
//            f.add(edit);
//
//            menuPanel.add(f);
//        }

        for(int i = 0; i< menuDic.get("name").size(); i++){

            JPanel f = new JPanel();
            f.setBackground(GREY_WHITE);
            f.setLayout(new GridLayout(0, 1));

            JLabel name = new JLabel("Name: " + menuDic.get("name").get(i));
            JLabel price = new JLabel("Price: " + menuDic.get("price").get(i));
            JLabel category = new JLabel("Category: " + menuDic.get("category").get(i));
            JLabel description = new JLabel("Description: " + menuDic.get("description").get(i));
            JButton delete = new JButton("Delete");
            JButton edit = new JButton("Edit");

            name.setBorder(emptyBorder2);
            price.setBorder(emptyBorder2);
            category.setBorder(emptyBorder2);
            description.setBorder(emptyBorder2);

            f.add(name);
            f.add(price);
            f.add(category);
            f.add(description);
            f.add(delete);
            f.add(edit);

            menuPanel.add(f);

        }

        JPanel buttonPanel = new JPanel(new GridLayout(0, 2));
        buttonPanel.setBorder(emptyBorder);

        JButton addFoodButton = new JButton("Add Item");
        JButton finishButton = new JButton("Finish");
        JButton refreshButton = new JButton("Refresh");

        buttonPanel.add(addFoodButton);
        buttonPanel.add(finishButton);

        frame.getContentPane().add(resNamePanel, BorderLayout.NORTH);
        frame.getContentPane().add(menuPanel, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);

    }
    public void actionPerformed(ActionEvent e){

    }
}
