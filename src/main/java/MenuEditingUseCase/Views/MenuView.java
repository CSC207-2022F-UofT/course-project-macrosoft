package MenuEditingUseCase.Views;

import Entities.*;
import MenuEditingUseCase.GetMenuInteractor;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MenuView {

    public MenuView(Restaurant curRes){

        final JFrame frame = new JFrame();
        Border emptyBorder = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);

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

        for(Food curFood: curMenu.getFoodList()){
            JPanel f = new JPanel();

            f.setLayout(new GridLayout(0, 1));
            f.setBorder(blackline);

            JLabel name = new JLabel("Name: " + curFood.getName());
            JLabel price = new JLabel("Price: " + Float.toString(curFood.getPrice()));
            JLabel category = new JLabel("Category: " + curFood.getCategory());
            JLabel description = new JLabel("Description: " + curFood.getDescription());
            JButton delete = new JButton("Delete");

            name.setBorder(emptyBorder2);
            price.setBorder(emptyBorder2);
            category.setBorder(emptyBorder2);
            description.setBorder(emptyBorder2);
            delete.setBorder(blackline);


            f.add(name);
            f.add(price);
            f.add(category);
            f.add(description);
            f.add(delete);

            menuPanel.add(f);
        }

        JPanel buttonPanel = new JPanel(new GridLayout(0, 2));
        buttonPanel.setBorder(emptyBorder);

        JButton addFoodButton = new JButton("Add Item");
        JButton finishButton = new JButton("Finish");

        buttonPanel.add(addFoodButton);
        buttonPanel.add(finishButton);


        frame.getContentPane().add(resNamePanel, BorderLayout.NORTH);
        frame.getContentPane().add(menuPanel, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);

    }
}
