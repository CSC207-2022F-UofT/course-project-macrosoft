package database;

import entities.*;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is responsible for all interactions with the MongoDB database
 * related to menus.
 */
public class MenuDataMongo implements MenuDataGateway {

    MongoCollectionFetcher mongoCollectionFetcher;

    /**
     * Constructor for MenuDataMongo
     *
     * @param mongoCollectionFetcher the fetcher for the collection
     */
    public MenuDataMongo(MongoCollectionFetcher mongoCollectionFetcher) {
        this.mongoCollectionFetcher = mongoCollectionFetcher;
    }

    /**
     * Gets menu id by restaurant id
     *
     * @param restaurantId the restaurant id
     * @return the menu id of the restaurant
     */
    @Override
    public ObjectId newMenu(ObjectId restaurantId) {
        Document newMenuDoc = new Document("restaurantId", restaurantId)
                .append("Food", new ArrayList<>());

        return this.mongoCollectionFetcher.getCollection("Menus").insertOne(newMenuDoc).getInsertedId().asObjectId().getValue();
    }

    /**
     * Sets the menu of a restaurant
     *
     * @param resId   the restaurant id
     * @param newMenu the new menu
     */
    @Override
    public void setMenu(ObjectId resId, Menu newMenu) {
        Bson filter = Filters.eq("restaurantId", resId);
        mongoCollectionFetcher.getCollection("Menus").deleteOne(filter);
        Document newMenuDoc = convertMenuToDoc(newMenu);
        mongoCollectionFetcher.getCollection("Menus").insertOne(newMenuDoc);
    }

    /**
     * Gets menu by restaurant id
     *
     * @param restId the restaurant id
     * @return the menu with the given restaurant id
     */
    @Override
    public Menu getMenu(ObjectId restId) {
        Bson queryFilter = Filters.and(
                Filters.eq("restaurantId", restId));

        MongoIterable<Document> menus = mongoCollectionFetcher.getCollection("Menus").find(queryFilter);

        if (menus.first() != null) {
            Document menuDoc = menus.first();
            return convertDocToMenu(menuDoc);
        } else {
            Document newMenuDoc = new Document("restaurantId", restId);
            newMenuDoc.append("Food", new ArrayList<>());
            InsertOneResult result = mongoCollectionFetcher.getCollection("Menus").insertOne(newMenuDoc);

            return convertDocToMenu(newMenuDoc);
        }
    }

    /**
     * Converts a menu to a document
     *
     * @param curMenu the menu to convert
     * @return the document
     */
    public Document convertMenuToDoc(Menu curMenu) {
        List<Document> foodDocLst = new ArrayList<>();
        for (Food curFood : curMenu.getFoodList()) {
            foodDocLst.add(convertFoodToDoc(curFood));
        }

        return new Document("_id", curMenu.getMenuId())
                .append("restaurantId", curMenu.getRestaurantId())
                .append("Food", foodDocLst);
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

    /**
     * Converts a food to a document
     *
     * @param curFood the food to convert
     * @return the document
     */
    public Document convertFoodToDoc(Food curFood) {
        return new Document("_id", curFood.getItemID())
                .append("name", curFood.getName())
                .append("description", curFood.getDescription())
                .append("category", curFood.getCategory())
                .append("price", curFood.getPrice());
    }
}
