package user_make_review_use_case.screens;

import datamodels.MakeReviewResponseModel;
import entities.Review;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReviewUI extends JFrame {

    Review rev;

    public ReviewUI(MakeReviewResponseModel successResponse) {
        this.rev = successResponse.getReview();

        setTitle("Review Information");
        setSize(900, 700);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Subject Line:"));
        add(new JLabel(this.rev.getSubjectLine()));

        add(new JLabel("Comment:"));
        add(new JLabel(this.rev.getComment()));

        add(new JLabel("Rating:"));
        int r = this.rev.getRating();
        add(new JLabel(String.valueOf(r) + " / 10"));

        add(new JLabel("Time:"));
        add(new JLabel(this.rev.getLastEditTime().toString()));

        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(ok);

        pack();
        setVisible(true);

        // Center the frame on the screen
        setLocationRelativeTo(null);
    }

}
