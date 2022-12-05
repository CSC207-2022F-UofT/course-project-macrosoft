package user_view_menu_use_case;

import org.bson.types.ObjectId;

import javax.swing.*;

public class Test {

    public Test() {
        DisplayMenuPresenter presenter = new DisplayMenuProcessor(null);
        DisplayMenuInputBoundary interactor = new DisplayMenuInteractor(presenter);
        DisplayMenuController controller = new DisplayMenuController(interactor, new ObjectId("63797394ee00665db6a0a950"));

        final JFrame frame = new JFrame();
        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        DisplayMenuPanelInterface displayMenuPanel = new DisplayMenuPanel(controller);

        frame.add((JPanel)displayMenuPanel);

        presenter.setDisplayMenuPanel(displayMenuPanel);
        displayMenuPanel.updatePanelData();

        frame.setVisible(true);

    }

    public static void main(String[] args) {

        Test test = new Test();

    }
}
