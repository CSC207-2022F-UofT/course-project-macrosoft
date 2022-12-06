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

public class MenuDataMongo implements MenuDataGateway{

    MongoCollectionFetcher mongoCollectionFetcher;

    public MenuDataMongo(MongoCollectionFetcher mongoCollectionFetcher) {
        this.mongoCollectionFetcher = mongoCollectionFetcher;
    }

    @Override
    public ObjectId newMenu(ObjectId restaurantId) {
        Document newMenuDoc = new Document("restaurantId", restaurantId)
                .append("Food", new ArrayList<>());

        return this.mongoCollectionFetcher.getCollection("Menus").insertOne(newMenuDoc).getInsertedId().asObjectId().getValue();
    }

    /**
     *
     * @param curRes
     * @param newMenu
     */
    @Override
    public void setMenu(Restaurant curRes, Menu newMenu){
        Bson filter = Filters.eq("restaurantId", curRes.getRestaurantID());
        mongoCollectionFetcher.getCollection("Menus").deleteOne(filter);
        Document newMenuDoc = convertMenuToDoc(newMenu);
        mongoCollectionFetcher.getCollection("Menus").insertOne(newMenuDoc);
    }

    /**
     *
     * @param curRes
     * @return
     */
    @Override
    public Menu getMenu(Restaurant curRes) {

        ObjectId restId = curRes.getRestaurantID();
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

    public Menu getMenu(ObjectId restId){
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
     *
     * @param curMenu
     * @return
     */

    public Document convertMenuToDoc(Menu curMenu){
        List<Document> foodDocLst = new ArrayList<>();
        for(Food curFood: curMenu.getFoodList()){
            foodDocLst.add(convertFoodToDoc(curFood));
        }

//        return new Document("restaurantId", curMenu.getRestaurantId())
//                .append("Food", foodDocLst);
        return new Document("_id", curMenu.getMenuId())
                .append("restaurantId", curMenu.getRestaurantId())
                .append("Food", foodDocLst);
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
