package res_display_menu_usecase;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ResDisplayMenuTest {

    /**
     * We are only testing the controller because other methods and classes can be reached by controller.
     */
    @Test
    public void test_get_resId() {
        ResDisplayMenuOutputBoundary presenter = new ResDisplayMenuPresenter(null);
        ResDisplayMenuInputBoundary interactor = new ResDisplayMenuInteractor(presenter);
        ResDisplayMenuController controller = new ResDisplayMenuController(interactor, new ObjectId("63797394ee00665db6a0a950"));

        ObjectId resId =  controller.getRestId();
        Assertions.assertEquals(resId.toString(), "63797394ee00665db6a0a950");
    }
}