package menu_editing_use_case;

import org.bson.types.ObjectId;


// Interface Adapters layer

/**
 * This class is the controller for the add food use case.
 */
public class MenuEditingController {
    final AddFoodInputBoundary add_input;
    final RemoveFoodInputBoundary remove_input;

    ObjectId resId;

    /**
     * Constructor for MenuEditingController
     *
     * @param add_input    the add food input boundary
     * @param remove_input the remove food input boundary
     * @param resId        the restaurant id
     */
    public MenuEditingController(AddFoodInputBoundary add_input, RemoveFoodInputBoundary remove_input, ObjectId resId) {
        this.add_input = add_input;
        this.remove_input = remove_input;
        this.resId = resId;
    }

    /**
     * Adds a new food item to the menu.
     *
     * @param name        the name
     * @param category    the category
     * @param description the description
     * @param price       the price
     */
    public void add(String name, String description, String category, float price) {
        AddFoodRequestModel requestModel = new AddFoodRequestModel(resId,
                add_input.getMenu(),
                name,
                description,
                category,
                price);
        add_input.create(requestModel);
    }

    /**
     * Removes a food item from the menu by food id.
     *
     * @param foodID the food id
     */
    public void remove(ObjectId foodID) {
        RemoveFoodRequestModel requestModel = new RemoveFoodRequestModel(resId,
                remove_input.getMenu(),
                foodID);
        remove_input.create(requestModel); //correct
    }

}
