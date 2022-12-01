package MenuEditingUseCase.Screens;

// Interface adapters layer

import MenuEditingUseCase.MenuEditingPresenter;
import MenuEditingUseCase.MenuEditingResponseModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class MenuEditingResponseFormatter implements MenuEditingPresenter {

    private JPanel MenuPanel;

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color BG_LIGHT_GREEN = new Color(87, 118, 83);
    private static final Color HL_LIGHT_GREEN = new Color(166, 199, 148);
    private static final Color HL_ORANGE_YELLOW = new Color(232, 181, 93);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Color WHITE = new Color(255, 255, 255);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    private static final Border blackline = BorderFactory.createLineBorder(Color.black);

    @Override
    public MenuEditingResponseModel prepareSuccessView(MenuEditingResponseModel response){
        HashMap<String, List> menuDic = response.getMenuDic();
        JPanel menuPanel = new JPanel();
        menuPanel.setBorder(blackline);
        GridLayout layout = new GridLayout(0, 3);
        layout.setVgap(40);
        layout.setHgap(40);
        menuPanel.setLayout(layout);
        menuPanel.setBorder(emptyBorder);

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
        this.MenuPanel = menuPanel;

        return response;
    }

    @Override
    public MenuEditingResponseModel prepareFailView(String str) {
        return null;
    }

    public JPanel getMenuPanel() {
        return MenuPanel;
    }
}
