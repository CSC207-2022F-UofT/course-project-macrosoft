package MenuEditingUseCase.first_try;

import java.util.*;
import java.util.stream.Collectors;

import Entities.*;
import org.bson.Document;

public class MenuDataConverter {

    /**
     *
     * @param menuDoc
     * @return
     */
    public static Menu convertDocToMenu(Document menuDoc){
//        if(menuDoc.getList("Food", Document.class).isEmpty()){
//            return new Menu(new ArrayList<Food>(), menuDoc.getObjectId("restaurantId"),menuDoc.getObjectId("_id"));
//        }

        List<Food> foodList = menuDoc.getList("Food", Document.class).
                stream()
                .map(doc -> FoodDataConverter.convertDocToFood(doc))
                .collect(Collectors.toList());

        return new Menu(foodList, menuDoc.getObjectId("restaurantId"),
                menuDoc.getObjectId("_id"));
    }

    /**
     *
     * @param curMenu
     * @return
     */

    public static Document convertMenuToDoc(Menu curMenu){
        List<Document> foodDocLst = new ArrayList<>();
        for(Food curFood: curMenu.getFoodList()){
            foodDocLst.add(FoodDataConverter.convertFoodToDoc(curFood));
        }

        return new Document("Food", foodDocLst)
                .append("restaurantId", curMenu.getRestaurantId());
    }

}
