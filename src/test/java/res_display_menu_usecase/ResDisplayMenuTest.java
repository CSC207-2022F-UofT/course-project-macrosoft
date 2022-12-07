package res_display_menu_usecase;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;

class ResDisplayMenuTest {

    @Test
    public void test_get_resId() {
        ResDisplayMenuPresenter presenter = new ResDisplayMenuProcessor(null);
        ResDisplayMenuInputBoundary interactor = new ResDisplayMenuInteractor(presenter);
        ResDisplayMenuController controller = new ResDisplayMenuController(interactor, new ObjectId("63797394ee00665db6a0a950"));

        ObjectId resId =  controller.getRestId();
        Assertions.assertEquals(resId.toString(), "63797394ee00665db6a0a950");
//        final JFrame frame = new JFrame();
//        frame.setSize(900, 700);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null);

//        ResDisplayMenuPanelInterface displayMenuPanel = new ResDisplayMenuPanel(controller);

//        frame.add((JPanel)displayMenuPanel);
//
//        presenter.setDisplayMenuPanel(displayMenuPanel);
//        displayMenuPanel.updatePanelData();
//
//        frame.setVisible(true);
    }

    @Test
    void addItem() {
    }

    @Test
    void getRestId() {
    }
}