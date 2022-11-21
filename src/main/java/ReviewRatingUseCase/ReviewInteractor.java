package ReviewRatingUseCase;

import Entities.Review;

import Interactors.DBConnection;
import Interactors.MongoConnection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;

import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.bson.Document;


public class ReviewInteractor {

    private static final DBConnection conn = new MongoConnection();

    /** rate an Order (connected by orderID) by setting a Review, overwrite that data in MongoDB */
    public static void setOrderReview(ObjectId orderID, Review review) {
        // convert
        Document doc = DocumentReviewConverter.convertReviewToDocument(review);

        // read db to see if review of this particular order already exists
        MongoCollection reviewCollection = conn.getCollection("Review");

        // matching requirement
        Bson filter = Filters.eq("orderID", orderID);

        // upsert: update if exists, insert if not exists
        ReplaceOptions options = new ReplaceOptions().upsert(true);

        // overwrite doc into db review collection
        reviewCollection.replaceOne(filter, options);
    }

}
