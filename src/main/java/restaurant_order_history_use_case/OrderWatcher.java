package restaurant_order_history_use_case;

import com.mongodb.client.ChangeStreamIterable;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.changestream.FullDocument;
import database.MongoCollectionFetcher;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import javax.swing.*;
import org.bson.Document;
import java.util.Arrays;
import java.util.List;

// Use case layer

public class OrderWatcher extends Thread {
    private RestaurantOrderHistoryPresenter presenter;
    private ObjectId restaurantId;
    private ChangeStreamIterable<Document> changeStream;

    public OrderWatcher(RestaurantOrderHistoryPresenter presenter, ObjectId restaurantId) {
        this.presenter = presenter;
        this.restaurantId = restaurantId;
    }

    public void run() {
        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();

        List<Bson> pipeline = Arrays.asList(
                Aggregates.match(Filters.eq("operationType", "insert"))
        );

        changeStream = fetcher.getCollection("Orders").watch(pipeline).fullDocument(FullDocument.UPDATE_LOOKUP);
        changeStream.forEach(doc -> isRestaurant(doc.getFullDocument(), restaurantId));
    }

    public void interrupt() {
        changeStream.cursor().close();
    }

    public void isRestaurant(Document doc, ObjectId restaurantId) {
        if (doc.getObjectId("restaurantID").toHexString().equals(restaurantId.toHexString())) presenter.newOrder();
    }
}
