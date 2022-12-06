package screens;

import login_use_case.*;
import org.bson.types.ObjectId;
import user_view_menu_use_case.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantComponent extends JPanel {

    public RestaurantComponent(JLabel label, ObjectId restaurantId) {
        JButton detailButton = new JButton("Detail");

        detailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayMenuPresenter presenter = new DisplayMenuProcessor(null);
                DisplayMenuInputBoundary interactor = new DisplayMenuInteractor(presenter);
                DisplayMenuController controller = new DisplayMenuController(interactor, restaurantId);

                final JFrame frame = new JFrame();
                frame.setSize(900, 700);
                frame.setLocationRelativeTo(null);

                DisplayMenuPanelInterface displayMenuPanel = new DisplayMenuPanel(controller);

                frame.add((JPanel)displayMenuPanel);

                presenter.setDisplayMenuPanel(displayMenuPanel);
                displayMenuPanel.updatePanelData();

                frame.setVisible(true);
            }
        });

        this.add(label);
        this.add(detailButton);
    }
}
