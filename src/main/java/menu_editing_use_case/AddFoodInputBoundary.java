package menu_editing_use_case;

//Application Business Rule layer

import entities.*;
import org.bson.types.ObjectId;

/**
 * This interface is the input boundary for the add food use case.
 */
public interface AddFoodInputBoundary {

    /**
     * Creates a new food item and adds it to the menu.
     *
     * @param requestModel the request model
     */
    void create(AddFoodRequestModel requestModel);

    /**
     * Gets the menu.
     *
     * @return the menu
     */
    Menu getMenu();

    /**
     * Gets the restaurant id.
     *
     * @return the restaurant id
     */
    ObjectId getResId();
}
