package user_make_review_use_case;

import javax.swing.*;
import java.awt.*;

public class ReviewUI extends JFrame {

    String rev;

    public ReviewUI(MakeReviewResponseModel successResponse) {
        this.rev = successResponse.getReviewId();

        setTitle("Review Information");
        setSize(900, 700);
        setLayout(new GridLayout(0, 1));

        add(new JLabel("Review Id: " + rev));

        JButton ok = new JButton("OK");
        ok.addActionListener(e -> dispose());
        add(ok);

        pack();
        setVisible(true);

        // Center the frame on the screen
        setLocationRelativeTo(null);
    }
}
