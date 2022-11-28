package MenuEditingUseCase;
import Entities.*;

public interface AddFoodInputBoundary {

    MenuEditingResponseModel create(AddFoodRequestModel requestModel);

    Menu getMenu(Restaurant curRes);

}
