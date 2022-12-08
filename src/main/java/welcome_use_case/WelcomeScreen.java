package welcome_use_case;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeScreen {

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder3 = BorderFactory.createEmptyBorder(200, 0, 20, 0);
    private static final Border emptyBorder4 = BorderFactory.createEmptyBorder(10, 0, 0, 10);


    public WelcomeScreen(WelcomeScreenController controller) {

        // creating the window
        final JFrame frame = new JFrame();
        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);


        // set up the main content panel
        JPanel mainContentPanel = new JPanel();
        mainContentPanel.setBackground(BG_DARK_GREEN);
        mainContentPanel.setLayout(new BorderLayout());
        mainContentPanel.setOpaque(true);


        // creating the centre panel
        JPanel centrePanel = new JPanel();
        centrePanel.setOpaque(false);
        JLabel greetingLabel = new JLabel("WELCOME TO SKIP-THE-LINE");
        greetingLabel.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        greetingLabel.setForeground(GREY_WHITE);
        greetingLabel.setBorder(emptyBorder3);
        centrePanel.add(greetingLabel);

        // creating the credit panel
        JPanel creditPanel = new JPanel();
        creditPanel.setOpaque(false);
        JLabel creditLabel = new JLabel("Developed by David Lin, Allen Xu, Leo Liu, Kevin Yang, Peter Yang, Jackson Su, Yinuo Zhao");
        creditLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        creditLabel.setForeground(GREY_WHITE);
        creditLabel.setBorder(emptyBorder);
        creditPanel.add(creditLabel);

        // creating the login/register panel
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new GridLayout(1, 6));

        JLabel placeTaker1 = new JLabel();
        actionPanel.add(placeTaker1);
        JLabel placeTaker2 = new JLabel();
        actionPanel.add(placeTaker2);

        actionPanel.setOpaque(false);
        JButton loginButton = new JButton("LOGIN");
        JButton registerButton = new JButton("REGISTER AS USER");
        JButton registerAsRestButton = new JButton("REGISTER AS RESTAURANT");
        registerAsRestButton.setOpaque(false);
        loginButton.setOpaque(false);
        registerButton.setOpaque(false);
        loginButton.setFont(new Font("Serif", Font.BOLD, 15));
        registerButton.setFont(new Font("Serif", Font.BOLD, 15));
        registerAsRestButton.setFont(new Font("Serif", Font.BOLD, 15));
        loginButton.setForeground(BG_DARK_GREEN);
        registerButton.setForeground(BG_DARK_GREEN);
        registerAsRestButton.setForeground(BG_DARK_GREEN);

        loginButton.addActionListener(new ActionListener() {
            /**
             * create anew login screen
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.getLoginScreen();

                frame.dispose();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            /**
             * create a new register screen
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.getRegisterUserScreen();

                frame.dispose();
            }
        });

        registerAsRestButton.addActionListener(new ActionListener() {
            /**
             * create a new restaurant register screen
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                controller.getRegisterRestaurantScreen();
                frame.dispose();
            }
        });

        actionPanel.add(loginButton);
        actionPanel.add(registerButton);
        actionPanel.add(registerAsRestButton);
        actionPanel.setBorder(emptyBorder4);

        JLabel placeTaker3 = new JLabel();
        actionPanel.add(placeTaker3);
        JLabel placeTaker4 = new JLabel();
        actionPanel.add(placeTaker4);
        centrePanel.add(actionPanel);

        // add everything tho the main content panel
        mainContentPanel.add(centrePanel, BorderLayout.CENTER);
        mainContentPanel.add(creditPanel, BorderLayout.SOUTH);

        frame.add(mainContentPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
