package res_display_menu_usecase;

import org.bson.types.ObjectId;
import user_shopping_cart_use_case.ShoppingCartSingleton;

/**
 * This class is the controller for the display menu use case.
 */
public class ResDisplayMenuController {

    private final ResDisplayMenuInputBoundary interactor;

    private final ObjectId restId;

    /**
     * Constructor for ResDisplayMenuController
     *
     * @param interactor the interactor
     * @param restId     the restaurant id
     */
    public ResDisplayMenuController(ResDisplayMenuInputBoundary interactor, ObjectId restId) {
        this.interactor = interactor;
        this.restId = restId;
    }

    /**
     * Displays the menu page.
     */
    public void displayMenuPage() {
        ResDisplayMenuRequestModel requestModel = new ResDisplayMenuRequestModel(restId);
        interactor.displayMenu(requestModel);
    }

    /**
     * Gets the restaurant id
     *
     * @return the restaurant id
     */
    public ObjectId getRestId() {
        return restId;
    }
}
