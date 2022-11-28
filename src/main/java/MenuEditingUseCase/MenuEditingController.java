package MenuEditingUseCase;
import Entities.*;

public class MenuEditingController {
    final AddFoodInputBoundary add_input;
    final RemoveFoodInputBoundary remove_input;

    private Restaurant curRestaurant;

    public MenuEditingController(Restaurant curRestaurant, AddFoodInputBoundary add_input, RemoveFoodInputBoundary remove_input) {
        this.curRestaurant = curRestaurant;
        this.add_input = add_input;
        this.remove_input = remove_input;
    }

    MenuEditingResponseModel create(String name, String description, String category, float price){
        AddFoodRequestModel requestModel = new AddFoodRequestModel(curRestaurant,
                add_input.getMenu(curRestaurant),
                name,
                description,
                category,
                price);
        return add_input.create(requestModel);
    }

    MenuEditingResponseModel create(Restaurant curRes, Food delFood){
        RemoveFoodRequestModel requestModel = new RemoveFoodRequestModel(curRes,
                add_input.getMenu(curRes),
                delFood);
        return remove_input.create(requestModel);
    }

    public Menu getMenu(Restaurant curRes){
        return add_input.getMenu(curRes);
    }

    public Restaurant getCurRestaurant() {
        return curRestaurant;
    }

    public void setCurRestaurant(Restaurant curRestaurant) {
        this.curRestaurant = curRestaurant;
    }
}
