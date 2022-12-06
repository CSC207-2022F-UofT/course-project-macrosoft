package user_view_menu_use_case;
import org.bson.types.*;
import user_shopping_cart_use_case.ShoppingCartSingleton;

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

    public void addItem(ObjectId foodId, String quantity) {
        int quantityInt = Integer.parseInt(quantity);
        ShoppingCartSingleton.getSingletonInstance().addFood(foodId, quantityInt);
    }

    public ObjectId getRestId() {
        return restId;
    }
}
