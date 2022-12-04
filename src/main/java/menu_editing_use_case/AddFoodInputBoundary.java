package menu_editing_use_case;

//Application Business Rule layer

import java.util.HashMap;
import java.util.List;
import entities.*;

public interface AddFoodInputBoundary {

    MenuEditingResponseModel create(AddFoodRequestModel requestModel);

    Menu getMenu();

    Restaurant getCurRes();

    HashMap<String, List> getMenuDic();


}
