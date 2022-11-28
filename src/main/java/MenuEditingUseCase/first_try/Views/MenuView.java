package MenuEditingUseCase.first_try.Views;

import Entities.*;
import MenuEditingUseCase.first_try.GetMenuInteractor;
import MenuEditingUseCase.first_try.RemoveFoodInteractor;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MenuView {

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color BG_LIGHT_GREEN = new Color(87, 118, 83);
    private static final Color HL_LIGHT_GREEN = new Color(166, 199, 148);
    private static final Color HL_ORANGE_YELLOW = new Color(232, 181, 93);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Color WHITE = new Color(255, 255, 255);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);


    public MenuView(Restaurant curRes){

        final JFrame frame = new JFrame();

        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JPanel resNamePanel = new JPanel();
        JLabel label = new JLabel(curRes.getName());
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
        Entities.Menu curMenu = GetMenuInteractor.getMenu(curRes.getRestaurantID());

        for(Food curFood: curMenu.getFoodList()) {
            JPanel f = new JPanel();
            f.setBackground(GREY_WHITE);
            f.setLayout(new GridLayout(0, 1));

            JLabel name = new JLabel("Name: " + curFood.getName());
            JLabel price = new JLabel("Price: " + Float.toString(curFood.getPrice()));
            JLabel category = new JLabel("Category: " + curFood.getCategory());
            JLabel description = new JLabel("Description: " + curFood.getDescription());
            JButton delete = new JButton("Delete");
            JButton edit = new JButton("Edit");

            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    RemoveFoodInteractor.remove(curMenu,curFood);

                }
            });

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
        addFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JButton finishButton = new JButton("Finish");
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPanel.removeAll();
                displayFoodPanels(GetMenuInteractor.getMenu(curRes.getRestaurantID()), menuPanel);
            }
        });
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        buttonPanel.add(addFoodButton);
        buttonPanel.add(finishButton);

        frame.getContentPane().add(resNamePanel, BorderLayout.NORTH);
        frame.getContentPane().add(menuPanel, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);

    }
     public void displayFoodPanels(Entities.Menu curMenu, JPanel menuPanel){
         for(Food curFood: curMenu.getFoodList()) {
             JPanel f = new JPanel();
             f.setBackground(GREY_WHITE);
             f.setLayout(new GridLayout(0, 1));

             JLabel name = new JLabel("Name: " + curFood.getName());
             JLabel price = new JLabel("Price: " + Float.toString(curFood.getPrice()));
             JLabel category = new JLabel("Category: " + curFood.getCategory());
             JLabel description = new JLabel("Description: " + curFood.getDescription());
             JButton delete = new JButton("Delete");
             JButton edit = new JButton("Edit");

             delete.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     RemoveFoodInteractor.remove(curMenu,curFood);

                 }
             });

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
     }
}
