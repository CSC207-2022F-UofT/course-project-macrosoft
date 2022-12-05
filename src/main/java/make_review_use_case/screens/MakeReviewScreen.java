package make_review_use_case.screens;

import entities.Order;

import make_review_use_case.MakeReviewController;
import datamodels.MakeReviewRequestModel;
import datamodels.MakeReviewResponseModel;
import screens.LabelTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;


public class MakeReviewScreen extends JFrame implements ActionListener {

    MakeReviewController makeReviewController;

    JTextField subjectField;
    JTextField commentField;
    JComboBox<Integer> rating;

    Order curOrder;

    /**
     * A window with text input fields and buttons for user to input review info for an order
     */
    public MakeReviewScreen(MakeReviewController controller, Order curOrder) {

        this.makeReviewController = controller;
        this.curOrder = curOrder;

        this.setSize(900, 700);

        JLabel title = new JLabel("Review");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        Integer[] ratingChoices = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        this.rating = new JComboBox<>(ratingChoices);

        JLabel subjectLabel = new JLabel("Subject:");
        this.subjectField = new JTextField("");
        LabelTextPanel subjectPanel = new LabelTextPanel(subjectLabel, subjectField);

        JLabel commentLabel = new JLabel("Comment:");
        this.commentField = new JTextField("");
        LabelTextPanel commentPanel = new LabelTextPanel(commentLabel, commentField);


        JButton save = new JButton("Save");
        JButton discard = new JButton("Discard");

        JPanel buttons = new JPanel();
        buttons.add(save);
        buttons.add(discard);

        save.addActionListener(this);
        discard.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(subjectPanel);
        main.add(commentPanel);
        main.add(buttons);
        this.setContentPane(main);

        this.pack();
    }

    private Integer parseRating() {
        return (Integer) this.rating.getSelectedItem();
    }

    private String parseSubject() {
        return this.subjectField.getText();
    }

    private String parseComment() {
        return this.subjectField.getText();
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        // Save the Review
        if (evt.getActionCommand().equals("Save")) {
            try {
                // read and parse the filled info
                Integer r = this.parseRating();
                String s = this.parseSubject();
                String c = this.parseComment();

                ArrayList<Path> lst = new ArrayList<>();
                Date d = new Date();

                // generate request based on model, dependency injection
                MakeReviewRequestModel request = new MakeReviewRequestModel(curOrder, r, c, lst, s, d);

                // pass request to controller to get a response
                MakeReviewResponseModel response = makeReviewController.makeReview(request);



            } catch (NullPointerException e) {  // error: certain required fields are empty
                JOptionPane.showMessageDialog(this,
                        "Please make sure all required information are filled before saving.");
                // end saving action
            }
        }

        // Discard the Review
        else if (evt.getActionCommand().equals("Discard")) {
            this.dispose();
        }
    }


}

