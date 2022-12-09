package res_display_menu_usecase;

import menu_editing_use_case.AddFoodInputBoundary;
import menu_editing_use_case.MenuEditingController;
import menu_editing_use_case.MenuEditingInteractor;
import menu_editing_use_case.RemoveFoodInputBoundary;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class is the test of restaurant display menu use case.
 */
class ResDisplayMenuTest {

    @Test
    public void res_test_display() {
        try {
            ObjectId resId = new ObjectId("63797394ee00665db6a0a950");
            AddFoodInputBoundary interactor_add = new MenuEditingInteractor(resId);
            RemoveFoodInputBoundary interactor_remove = new MenuEditingInteractor(resId);
            MenuEditingController controller1 = new MenuEditingController(interactor_add, interactor_remove, resId);

            ResDisplayMenuOutputBoundary presenter = new ResDisplayMenuPresenter(null);
            ResDisplayMenuInputBoundary interactor = new ResDisplayMenuInteractor(presenter);
            ResDisplayMenuController controller = new ResDisplayMenuController(interactor, new ObjectId("63797394ee00665db6a0a950"));
            ResDisplayMenuPanelInterface panel = new ResDisplayMenuPanel(controller, controller1);
            presenter.setDisplayMenuPanel(panel);
            controller.displayMenuPage();
            assert true;
        }
        catch (Exception e){
            assert false;
        }
    }

    @Test
    void addItem() {
    }

    @Test
    void getRestId() {
    }
}