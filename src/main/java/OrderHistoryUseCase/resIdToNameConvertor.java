package OrderHistoryUseCase;

import Database.MongoCollectionFetcher;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class resIdToNameConvertor {
    public String getResNameById(ObjectId resId){
        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
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
