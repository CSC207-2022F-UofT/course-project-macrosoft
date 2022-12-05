package make_review_use_case.screens;

import datamodels.MakeReviewResponseModel;
import entities.Review;

import javax.swing.*;
import java.awt.*;

public class ReviewUI extends JFrame {

    Review rev;

    public ReviewUI(MakeReviewResponseModel successResponse) {
        this.rev = successResponse.getReview();

        setTitle("Review Information");
        setSize(900, 700);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Subject Line:"));
        add(new JTextField(this.rev.getSubjectLine()));


        add(new JLabel("Comment:"));
        add(new JTextArea(this.rev.getComment()));

        add(new JLabel("Rating:"));
        int r = this.rev.getRating();
        add(new JTextField(String.valueOf(r) + " / 10"));

        add(new JLabel("Time:"));
        add(new JTextField(this.rev.getLastEditTime().toString()));

        pack();
        setVisible(true);
    }
}
