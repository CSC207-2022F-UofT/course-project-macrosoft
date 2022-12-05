package user_view_menu_use_case;
import org.bson.types.*;

public class DisplayMenuController {

    private DisplayMenuInputBoundary interactor;

    private ObjectId restId;

    public DisplayMenuController(DisplayMenuInputBoundary interactor, ObjectId restId) {
        this.interactor = interactor;
        this.restId = restId;
    }

    public void displayMenuPage(){
        DisplayMenuRequestModel requestModel = new DisplayMenuRequestModel(restId);
        interactor.displayMenu(requestModel);
    }

    public ObjectId getRestId() {
        return restId;
    }
}
