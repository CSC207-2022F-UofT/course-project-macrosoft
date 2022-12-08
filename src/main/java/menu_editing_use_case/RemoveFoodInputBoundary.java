package menu_editing_use_case;

// Application Business Rules Layer

import entities.Menu;
import org.bson.types.ObjectId;

/**
 * This class is the input boundary for the remove food use case.
 */
public interface RemoveFoodInputBoundary {

    /**
     * Removes a food item from the menu.
     *
     * @param requestModel the request model
     */
    void create(RemoveFoodRequestModel requestModel);

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
