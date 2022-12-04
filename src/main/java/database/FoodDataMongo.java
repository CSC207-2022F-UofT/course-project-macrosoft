package database;

import entities.Food;
import entities.Menu;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FoodDataMongo implements FoodDataGateway{
    MongoCollectionFetcher mongoCollectionFetcher;

    public FoodDataMongo(MongoCollectionFetcher mongoCollectionFetcher){
        this.mongoCollectionFetcher = mongoCollectionFetcher;
    }
    @Override
    public Food getFood(ObjectId foodId, ObjectId restId) {
        Bson queryFilter = Filters.eq("restaurantId", restId);
        MongoIterable<Document> menus = mongoCollectionFetcher.getCollection("Menus").find(queryFilter);

        if (menus.first() != null) {
            Document menuDoc = menus.first();
            Menu menu = convertDocToMenu(menuDoc);
            return menu.findFood(foodId);
        }
        return null;
    }

    public Document convertMenuToDoc(Menu curMenu){
        List<Document> foodDocLst = new ArrayList<>();
        for(Food curFood: curMenu.getFoodList()){
            foodDocLst.add(convertFoodToDoc(curFood));
        }

        return new Document("Food", foodDocLst)
                .append("restaurantId", curMenu.getRestaurantId());
    }

    /**
     *
     * @param menuDoc
     * @return
     */

    public Menu convertDocToMenu(Document menuDoc){

        List<Food> foodList = menuDoc.getList("Food", Document.class).
                stream()
                .map(doc -> convertDocToFood(doc))
                .collect(Collectors.toList());

        return new Menu(foodList, menuDoc.getObjectId("restaurantId"),
                menuDoc.getObjectId("_id"));
    }

    /**
     *
     * @param foodDoc
     * @return
     */

    public Food convertDocToFood(Document foodDoc){
        if (foodDoc.isEmpty()){
            return null;
        }
        return new Food(foodDoc.getString("name"),
                foodDoc.getString("description"),
                foodDoc.getString("category"),
                foodDoc.getDouble("price").floatValue(),
                foodDoc.getObjectId("_id"));
    }

    /**
     *
     * @param curFood
     * @return
     */

    public Document convertFoodToDoc(Food curFood){
        return new Document("_id", curFood.getItemID())
                .append("name", curFood.getName())
                .append("description", curFood.getDescription())
                .append("category", curFood.getCategory())
                .append("price", curFood.getPrice());
    }
}
