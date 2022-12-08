package restaurant_order_history_use_case;

import com.mongodb.client.ChangeStreamIterable;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.changestream.FullDocument;
import database.MongoCollectionFetcher;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import org.bson.Document;

import java.util.Arrays;
import java.util.List;

// Use case layer

/**
 * This class is the watcher for the restaurant order history use case.
 */
public class OrderWatcher extends Thread {
    private final RestaurantOrderHistoryOutputBoundary presenter;
    private final ObjectId restaurantId;
    private ChangeStreamIterable<Document> changeStream;

    /**
     * Constructor for OrderWatcher
     *
     * @param presenter    RestaurantOrderHistoryOutputBoundary presenter for the restaurant order history use case
     * @param restaurantId ObjectId restaurant id of the current restaurant
     */
    public OrderWatcher(RestaurantOrderHistoryOutputBoundary presenter, ObjectId restaurantId) {
        this.presenter = presenter;
        this.restaurantId = restaurantId;
    }

    /**
     * Run the thread
     */
    public void run() {
        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();

        List<Bson> pipeline = Arrays.asList(
                Aggregates.match(Filters.eq("operationType", "insert"))
        );

        changeStream = fetcher.getCollection("Orders").watch(pipeline).fullDocument(FullDocument.UPDATE_LOOKUP);
        changeStream.forEach(doc -> isRestaurant(doc.getFullDocument(), restaurantId));
    }

    /**
     * interrupt the thread
     */
    public void interrupt() {
        changeStream.cursor().close();
    }

    /**
     * Check if the restaurant is the current restaurant
     *
     * @param doc          Document order
     * @param restaurantId ObjectId restaurant id of the current restaurant
     */
    public void isRestaurant(Document doc, ObjectId restaurantId) {
        if (doc.getObjectId("restaurantID").toHexString().equals(restaurantId.toHexString())) presenter.newOrder();
    }
}
