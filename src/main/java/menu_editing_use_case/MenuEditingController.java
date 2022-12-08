package menu_editing_use_case;

import org.bson.types.ObjectId;


// Interface Adapters layer

/**
 * This class is the presenter for the add food use case.
 */
public class MenuEditingController {
    final AddFoodInputBoundary add_input;
    final RemoveFoodInputBoundary remove_input;

    ObjectId resId;

    public MenuEditingController(AddFoodInputBoundary add_input, RemoveFoodInputBoundary remove_input, ObjectId resId) {
        this.add_input = add_input;
        this.remove_input = remove_input;
        this.resId = resId;
    }

    public void add(String name, String description, String category, float price){
        AddFoodRequestModel requestModel = new AddFoodRequestModel(resId,
                add_input.getMenu(),
                name,
                category,
                description,
                price);
        add_input.create(requestModel);
    }

    public void remove(ObjectId foodID){
        RemoveFoodRequestModel requestModel = new RemoveFoodRequestModel(resId,
                remove_input.getMenu(),
                foodID);
        remove_input.create(requestModel); //correct
    }

}
