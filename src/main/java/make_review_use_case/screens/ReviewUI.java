package make_review_use_case.screens;

import datamodels.MakeReviewResponseModel;
import entities.Review;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class ReviewUI extends JFrame {

    Review rev;

    public ReviewUI(MakeReviewResponseModel successResponse) {
        this.rev = successResponse.getReview();

        setTitle("Review Information");
        setSize(900, 700);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Subject Line:"));
        add(new JTextField(this.rev.getSubjectLine()));


        add(new JLabel("Comment:"));
        add(new JTextArea(this.rev.getComment()));

        add(new JLabel("Rating:"));
        int r = this.rev.getRating();
        add(new JTextField(String.valueOf(r) + " / 10"));

        add(new JLabel("Time:"));
        add(new JTextField(this.rev.getLastEditTime().toString()));

        add(new JButton("OK"));

        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        this.dispose();
    }
}
