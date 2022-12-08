package user_make_review_use_case;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;

public class MakeReviewScreen extends JFrame implements ActionListener {
    MakeReviewController makeReviewController;
    JTextArea subjectArea;
    JTextArea commentArea;
    JComboBox<Integer> ratingBox;


    /**
     * A window with text input fields and buttons for user to input review info for an order
     */
    public MakeReviewScreen(MakeReviewController controller) {

        this.makeReviewController = controller;
        this.setLocationRelativeTo(null);


        JPanel titlePanel = new JPanel();
        titlePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        JLabel title = new JLabel("How's This Order?");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 30));
        titlePanel.add(title);

        Integer[] ratingChoices = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        this.ratingBox = new JComboBox<>(ratingChoices);
        JLabel ratingLabel = new JLabel("Rating:");
        JPanel ratingPanel = new JPanel();
        ratingPanel.add(ratingLabel);
        ratingPanel.add(ratingBox);
        ratingPanel.setBounds(100, 100,100,50);
        ratingPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subjectLabel = new JLabel("Subject:");
        this.subjectArea = new JTextArea();
        subjectArea.setColumns(30);
        subjectArea.setRows(2);
        JPanel subjectPanel = new JPanel();
        subjectPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
        subjectPanel.setLayout(new GridLayout(2, 1));
        subjectPanel.add(subjectLabel);
        subjectPanel.add(subjectArea);

        JLabel commentLabel = new JLabel("Comment:");
        this.commentArea = new JTextArea();
        commentArea.setColumns(30);
        commentArea.setRows(6);
        JPanel commentPanel = new JPanel();
        commentPanel.setLayout(new GridLayout(2, 1));
        commentPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
        commentPanel.add(commentLabel);
        commentPanel.add(commentArea);

        JButton save = new JButton("Save");
        JButton discard = new JButton("Discard");

        JPanel buttons = new JPanel();
        buttons.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        buttons.add(save);
        buttons.add(discard);

        save.addActionListener(this);
        discard.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(titlePanel);
        main.add(ratingPanel);
        main.add(subjectPanel);
        main.add(commentPanel);
        main.add(buttons);
        this.setContentPane(main);

        this.pack();

        // Center the frame on the screen
        this.setLocationRelativeTo(null);
    }

    private Integer parseRating() {
        return (Integer) this.ratingBox.getSelectedItem();
    }

    private String parseSubject() {
        return this.subjectArea.getText();
    }

    private String parseComment() {
        return this.commentArea.getText();
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

                makeReviewController.makeReview(r, c, lst, s, d);

                this.dispose();

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

