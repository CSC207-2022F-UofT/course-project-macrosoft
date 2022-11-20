package MenuEditingUseCase;

import Entities.Food;
import Entities.Menu;
import Interactors.DBConnection;
import Interactors.MongoConnection;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class EditCategoryInteractor {

    /**
     *
     * @param currMenu
     * @param currFood
     * @param newCategory
     */
    public static void modifyCategory(Menu currMenu, Food currFood, String newCategory){

        DBConnection connectionManager = new MongoConnection();

        ObjectId menuId = currMenu.getMenuId();
        Bson filter = Filters.eq("_id", menuId);
        MongoIterable<Document> results = connectionManager.getCollection("Menus").find(filter);
        Document menuDoc = results.first();

        List<Document> foodLst = menuDoc.getList("Food", Document.class);
        List<Food> foodObj = new ArrayList<>();

        for(Document doc : foodLst){
            foodObj.add(FoodDataConverter.convertDocToFood(doc));
        }

        for(Food curFood: foodObj){
            if(curFood.getItemID().toString().equals(currFood.getItemID().toString())){
                curFood.setCategory(newCategory);
                break;
            }
        }

        List<Document> newFoodDocLst = new ArrayList<>();
        for(Food curFood: foodObj){
            newFoodDocLst.add(FoodDataConverter.convertFoodToDoc(curFood));
        }

        Bson update = Updates.set("Food", newFoodDocLst);
        connectionManager.getCollection("Menus").updateOne(filter, update);
    }
}
