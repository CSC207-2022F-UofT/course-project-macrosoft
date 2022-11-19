package MenuEditingUseCase;

import java.util.*;

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

    public static Menu convert(Document menuDoc){
        List<Food> foodList = new ArrayList<>();
        return new Menu(foodList, menuDoc.getObjectId("restaurantID"),
                menuDoc.getObjectId("menuId"));
    }

}
