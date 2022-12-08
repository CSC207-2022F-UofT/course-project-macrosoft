package database;

import entities.Food;
import entities.Menu;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is responsible for all interactions with the MongoDB database
 * related to food.
 */
public class FoodDataMongo implements FoodDataGateway {
    MongoCollectionFetcher mongoCollectionFetcher;

    /**
     * Constructor for FoodDataMongo
     *
     * @param mongoCollectionFetcher the fetcher for the collection
     */
    public FoodDataMongo(MongoCollectionFetcher mongoCollectionFetcher) {
        this.mongoCollectionFetcher = mongoCollectionFetcher;
    }

    /**
     * Gets food by food id and restaurant id
     *
     * @param foodId the food id
     * @param restId the restaurant id
     * @return the food with the given food id and restaurant id
     */
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

    /**
     * Converts a document to a menu
     *
     * @param menuDoc the document to convert
     * @return the menu
     */
    public Menu convertDocToMenu(Document menuDoc) {

        List<Food> foodList = menuDoc.getList("Food", Document.class).
                stream()
                .map(doc -> convertDocToFood(doc))
                .collect(Collectors.toList());

        return new Menu(foodList, menuDoc.getObjectId("restaurantId"),
                menuDoc.getObjectId("_id"));
    }

    /**
     * Converts a document to a food
     *
     * @param foodDoc the document to convert
     * @return the food
     */
    public Food convertDocToFood(Document foodDoc) {
        if (foodDoc.isEmpty()) {
            return null;
        }
        return new Food(foodDoc.getString("name"),
                foodDoc.getString("description"),
                foodDoc.getString("category"),
                foodDoc.getDouble("price").floatValue(),
                foodDoc.getObjectId("_id"));
    }
}
