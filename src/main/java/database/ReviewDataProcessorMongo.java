package database;

import com.mongodb.client.result.InsertOneResult;
import entities.Review;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is responsible for all interactions with the MongoDB database
 * related to reviews.
 */
public class ReviewDataProcessorMongo implements ReviewDataGateway {
    MongoCollectionFetcher mongoCollectionFetcher;

    /**
     * Constructor for ReviewDataProcessorMongo
     *
     * @param fetcher the fetcher for the collection
     */
    public ReviewDataProcessorMongo(MongoCollectionFetcher fetcher) {
        this.mongoCollectionFetcher = fetcher;
    }

    /**
     * Saves a review to the database
     *
     * @param review the review to be saved
     * @return the id of the review
     */
    @Override
    public String save(Review review) {

        Document newDoc = convertReviewToDocument(review);

        InsertOneResult result = this.mongoCollectionFetcher.getCollection("Reviews").insertOne(newDoc);

        return result.getInsertedId().asObjectId().getValue().toHexString();
    }


    /**
     * Gets review collection from the database
     *
     * @return the Monga collection
     */
    private MongoCollection getReviewCollection() {
        return mongoCollectionFetcher.getCollection("Reviews");
    }


    /**
     * Finds a review by id
     *
     * @param id the id of a review
     * @return the review with the given id
     */
    @Override
    public Review findById(ObjectId id) {
        Bson filter = Filters.eq("_id", id);

        Document doc = (Document) getReviewCollection().find(filter).first();
        if (doc != null) {
            return convertDocumentToReview(doc);
        } else {
            return null;
        }
    }

    /**
     * find the review given the orderID
     *
     * @param OrderID the id of an order
     * @return review object if it exists, else null
     */
    @Override
    public Review findByOrderId(ObjectId OrderID) {
        Bson filter = Filters.eq("orderID", OrderID);
        Document doc = (Document) getReviewCollection().find(filter).first();
        if (doc != null) {
            return convertDocumentToReview(doc);
        } else {
            return null;
        }
    }

    /**
     * Converts a document object to a review object
     *
     * @param document the document to be converted
     * @return the review representation of the document
     */
    public static Review convertDocumentToReview(Document document) {
        List<Path> picPathList = null;

        return new Review(document.getObjectId("_id"),  // auto-generated ObjectId field "_id" for review by DB, used as reviewID
                document.getObjectId("orderID"),
                document.getInteger("rating"),
                document.getString("comment"),
                document.getString("subjectLine"),
                picPathList,
                document.getDate("lastEditTime"));
    }

    /**
     * Converts a review object to a document object
     *
     * @param review the review to be converted
     * @return the document representation of the review
     */
    public static Document convertReviewToDocument(Review review) {

        // no need for init ObjectId, as DB will auto-generate _id
        return new Document("comment", review.getComment())
                .append("orderID", review.getOrderID())
                .append("picPathList", review.getPicPathList())
                .append("subjectLine", review.getSubjectLine())
                .append("lastEditTime", review.getLastEditTime())
                .append("rating", review.getRating());
    }
}
