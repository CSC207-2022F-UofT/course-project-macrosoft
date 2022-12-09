package test_user_view_menu_use_case;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import res_display_menu_usecase.*;
import user_view_menu_use_case.*;

import static org.junit.jupiter.api.Assertions.*;

class DisplayMenuControllerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testDisplay(){
        try {
            DisplayMenuOutputBoundary presenter = new DisplayMenuPresenter(null);
            DisplayMenuInputBoundary interactor = new DisplayMenuInteractor(presenter);
            DisplayMenuController controller = new DisplayMenuController(interactor, new ObjectId("63797394ee00665db6a0a950"));
            DisplayMenuPanelInterface panel = new DisplayMenuPanel(controller);
            presenter.setDisplayMenuPanel(panel);
            controller.displayMenuPage();
            assert true;
        }
        catch (NullPointerException e){
            assert false;
        }
    }
}