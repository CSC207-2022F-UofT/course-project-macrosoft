package MenuEditingUseCase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import Entities.*;
import org.bson.Document;
import org.bson.conversions.Bson;

import LoginUseCase.LoginRestaurantInteractor;
import org.bson.types.ObjectId;

import Interactors.*;

public class GetMenuInteractor {
    private static DBConnection connectionManager = new MongoConnection();

    public static Menu getMenu(ObjectId restId) {
        Bson queryFilter = Filters.and(
                Filters.eq("restaurantID", restId));

        MongoIterable<Document> menus = connectionManager.getCollection("Menu").find(queryFilter);

        if(menus.first() != null){
            Document menuDoc = menus.first();
            return MenuDataConverter.convert(menuDoc);
        }
        else{
            Document newMenuDoc = new Document("restaurantId", restId);
            InsertOneResult result = connectionManager.getCollection("Menu").insertOne(newMenuDoc);

            return MenuDataConverter.convert(newMenuDoc);
        }
    }
}
