package MenuEditingUseCase;

import org.bson.types.ObjectId;


// Interface Adapters layer

public class MenuEditingController {
    final AddFoodInputBoundary add_input;
    final RemoveFoodInputBoundary remove_input;

    public MenuEditingController(AddFoodInputBoundary add_input, RemoveFoodInputBoundary remove_input) {
        this.add_input = add_input;
        this.remove_input = remove_input;
    }

    MenuEditingResponseModel create(String name, String description, String category, float price){
        AddFoodRequestModel requestModel = new AddFoodRequestModel(add_input.getCurRes(),
                add_input.getMenu(),
                name,
                description,
                category,
                price);
        return add_input.create(requestModel);
    }

    MenuEditingResponseModel create(ObjectId foodID){
        RemoveFoodRequestModel requestModel = new RemoveFoodRequestModel(remove_input.getCurRes(),
                remove_input.getMenu(),
                remove_input.getMenu().findFood(foodID));
        return remove_input.create(requestModel);
    }


    public AddFoodInputBoundary getAdd_input() {
        return add_input;
    }

    public RemoveFoodInputBoundary getRemove_input() {
        return remove_input;
    }
}
