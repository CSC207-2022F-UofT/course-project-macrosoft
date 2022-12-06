package res_display_menu_usecase;

import org.bson.types.ObjectId;
import user_shopping_cart_use_case.ShoppingCartSingleton;

public class ResDisplayMenuController {

    private ResDisplayMenuInputBoundary interactor;

    private ObjectId restId;

    public ResDisplayMenuController(ResDisplayMenuInputBoundary interactor, ObjectId restId) {
        this.interactor = interactor;
        this.restId = restId;
    }

    public void displayMenuPage(){
        ResDisplayMenuRequestModel requestModel = new ResDisplayMenuRequestModel(restId);
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
