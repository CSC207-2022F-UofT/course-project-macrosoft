package user_order_history_use_case;

import database.MongoCollectionFetcher;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * This class is the restaurant ID to restaurant name convertor for the order history use case
 */
public class resIdToNameConvertor {


    /**
     * Get the restaurant name by restaurant ID
     *
     * @param resId the restaurant ID
     * @return the restaurant name by the given ID
     */
    public String getResNameById(ObjectId resId){
        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        Bson queryFilter = Filters.eq("_id", resId);
        MongoIterable<Document> mongoIterable = fetcher.getCollection("Restaurants")
                .find(queryFilter);
        String resName = null;
        for (Document doc: mongoIterable) {
            resName = doc.getString("name");
        }

        return resName;
    }
}
