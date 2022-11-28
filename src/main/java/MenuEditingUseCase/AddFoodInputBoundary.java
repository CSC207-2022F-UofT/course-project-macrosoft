package MenuEditingUseCase;

//Application Business Rule layer

import Entities.*;

import java.util.HashMap;
import java.util.List;

public interface AddFoodInputBoundary {

    MenuEditingResponseModel create(AddFoodRequestModel requestModel);

    Menu getMenu();

    Restaurant getCurRes();

    HashMap<String, List> getMenuDic();

}
