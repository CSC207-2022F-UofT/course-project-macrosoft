package user_view_menu_use_case;

import entities.Food;
import entities.Menu;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class is the converter of menu to dictionary.
 */
public class MenuToDicConverter {

    /**
     * Converts menu to dictionary.
     *
     * @param curMenu a menu
     * @return a HashMap
     */
    public static HashMap<String, List> getMenuDic(Menu curMenu) {
        HashMap<String, List> menuDic = new HashMap<>();
        List<Food> foodLst = curMenu.getFoodList();

        List<String> nameList = new ArrayList<>();
        List<String> descriptionList = new ArrayList<>();
        List<String> categoryList = new ArrayList<>();
        List<Float> priceList = new ArrayList<>();
        List<ObjectId> idList = new ArrayList<>();

        for (Food curFood : foodLst) {
            nameList.add(curFood.getName());
            descriptionList.add(curFood.getDescription());
            categoryList.add(curFood.getCategory());
            priceList.add(curFood.getPrice());
            idList.add(curFood.getItemID());
        }

        menuDic.put("name", nameList);
        menuDic.put("description", descriptionList);
        menuDic.put("category", categoryList);
        menuDic.put("price", priceList);
        menuDic.put("id", idList);

        return menuDic;
    }

}
