package res_display_menu_usecase;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class is the test of restaurant display menu use case.
 */
class ResDisplayMenuTest {

    @Test
    public void test_get_resId() {
        ResDisplayMenuOutputBoundary presenter = new ResDisplayMenuPresenter(null);
        ResDisplayMenuInputBoundary interactor = new ResDisplayMenuInteractor(presenter);
        ResDisplayMenuController controller = new ResDisplayMenuController(interactor, new ObjectId("63797394ee00665db6a0a950"));

        ObjectId resId = controller.getRestId();
        Assertions.assertEquals(resId.toString(), "63797394ee00665db6a0a950");
    }

    @Test
    void addItem() {
    }

    @Test
    void getRestId() {
    }
}