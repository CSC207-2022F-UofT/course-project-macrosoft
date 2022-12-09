package res_display_menu_usecase;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ResDisplayMenuTest {

    @Test
    public void res_test_display() {
        try {
            ResDisplayMenuOutputBoundary presenter = new ResDisplayMenuPresenter(null);
            ResDisplayMenuInputBoundary interactor = new ResDisplayMenuInteractor(presenter);
            ResDisplayMenuController controller = new ResDisplayMenuController(interactor, new ObjectId("63797394ee00665db6a0a950"));
            controller.displayMenuPage();
            assert true;
        }
        catch (NullPointerException e){
            assert false;
        }

    }
}