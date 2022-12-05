package change_restaurant_info_use_case;


import screens.LabelTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class ChangeRestaurantInfoScreen extends JFrame implements ChangeRestaurantInfoScreenInterface, ActionListener {
    JTextField newName = new JTextField(15);
    JTextField newEmail = new JTextField(15);
    JTextField newLocation = new JTextField(15);
    JTextField newPhone = new JTextField(15);

    ChangeRestaurantInfoController controller;

    public ChangeRestaurantInfoScreen(ChangeRestaurantInfoController controller){
        this.controller = controller;

        JLabel title = new JLabel("Change Password");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel("New Name"), newName);
        LabelTextPanel emailInfo = new LabelTextPanel(
                new JLabel("New Email"), newEmail);
        LabelTextPanel locationInfo = new LabelTextPanel(
                new JLabel("New Location"), newLocation);
        LabelTextPanel phoneInfo = new LabelTextPanel(
                new JLabel("New Phone"), newPhone);

        JButton save = new JButton("Save");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(save);
        buttons.add(cancel);

        save.addActionListener(this);
        cancel.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(nameInfo);
        main.add(emailInfo);
        main.add(locationInfo);
        main.add(phoneInfo);
        main.add(buttons);
        this.setContentPane(main);

        this.pack();
    }


    @Override
    public void close() {
        this.dispose();
    }

    @Override
    public void showMessage(String message) {
        showMessageDialog(null, message);
    }

    @Override
    public JFrame getFrame() {
        return this;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Save")) {
            try {
                controller.changeRestaurantInfo(
                        newName.getText(),
                        newEmail.getText(),
                        newLocation.getText(),
                        newPhone.getText()
                );
            } catch (Exception e) {
                showMessageDialog(this, e.getMessage());
            }
        }
        else if (evt.getActionCommand().equals("Cancel")) {
            this.close();
        }
    }
}
