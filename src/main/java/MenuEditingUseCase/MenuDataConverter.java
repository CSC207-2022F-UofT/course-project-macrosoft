package MenuEditingUseCase;

import java.util.*;
import java.util.stream.Collectors;

import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import Entities.*;
import org.bson.Document;
import org.bson.conversions.Bson;

import LoginUseCase.LoginRestaurantInteractor;
import org.bson.types.ObjectId;

import Interactors.*;

public class MenuDataConverter {

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

    public static Document convertMenuToDoc(Menu curMenu){
        List<Document> foodDocLst = new ArrayList<>();
        for(Food curFood: curMenu.getFoodList()){
            foodDocLst.add(FoodDataConverter.convertFoodToDoc(curFood));
        }

        return new Document("Food", foodDocLst)
                .append("restaurantId", curMenu.getRestaurantId());
    }

}
