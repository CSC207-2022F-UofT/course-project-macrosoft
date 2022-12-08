package user_view_menu_use_case;

import org.bson.types.*;
import user_shopping_cart_use_case.ShoppingCartSingleton;

/**
 * This class is the controller of view menu use case.
 */
public class DisplayMenuController {

    private final DisplayMenuInputBoundary interactor;

    private final ObjectId restId;

    /**
     * Constructor of DisplayMenuController.
     *
     * @param interactor a display menu interactor
     * @param restId     a restaurant id
     */
    public DisplayMenuController(DisplayMenuInputBoundary interactor, ObjectId restId) {
        this.interactor = interactor;
        this.restId = restId;
    }

    /**
     * Display menu page.
     */
    public void displayMenuPage() {
        DisplayMenuRequestModel requestModel = new DisplayMenuRequestModel(restId);
        interactor.displayMenu(requestModel);
    }

    /**
     * Add food item to shopping cart by its id.
     *
     * @param foodId   an item id
     * @param quantity an item quantity
     */
    public void addItem(ObjectId foodId, String quantity) {
        if (quantity.isEmpty()) return;

        int quantityInt = Integer.parseInt(quantity);
        ShoppingCartSingleton.getSingletonInstance().addFood(foodId, quantityInt);
    }
}
