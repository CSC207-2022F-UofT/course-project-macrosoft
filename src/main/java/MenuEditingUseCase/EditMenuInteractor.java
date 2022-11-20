package MenuEditingUseCase;
import Entities.*;


import Interactors.DBConnection;
import Interactors.MongoConnection;
import com.mongodb.client.model.Updates;
import org.bson.BsonObjectId;
import org.bson.types.BasicBSONList;
import com.mongodb.client.*;

import com.mongodb.client.model.Filters;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import org.bson.types.ObjectId;
import org.bson.BsonValue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EditMenuInteractor {

    private static DBConnection connectionManager = new MongoConnection();

    public static void addFood(Menu curMenu, String name, String description, String category, float price){

        ObjectId menuId = curMenu.getMenuId();
        Document newFoodDoc = new Document("_id", new ObjectId());
        newFoodDoc.append("name", name).append("description",description).append("category", category).append("price", price);

        Bson filter = Filters.eq("_id", menuId);
        Bson update = Updates.push("Food", newFoodDoc);

        connectionManager.getCollection("Menus").updateOne(filter, update);

    }


    public static void deleteFood(Menu curMenu, Food delFood){
        ObjectId foodId = delFood.getItemID();
        ObjectId menuId = curMenu.getMenuId();

        Bson filter = Filters.eq("_id", menuId);

        MongoIterable<Document> results = connectionManager.getCollection("Menus").find(filter);
        Document menuDoc = results.first();


        List<Document> foodLst = menuDoc.getList("Food", Document.class);
        List<Food> foodObj = new ArrayList<>();

        for(Document doc : foodLst){
            foodObj.add(FoodDataConverter.convertDocToFood(doc));
        }

        for(Food curFood: foodObj){
            if(curFood.getItemID().toString().equals(foodId.toString())){
                foodObj.remove(curFood);
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
