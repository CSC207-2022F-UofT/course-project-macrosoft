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
public class ReviewDataProcessorMongo implements ReviewDataGateway{
    MongoCollectionFetcher mongoCollectionFetcher;

    public ReviewDataProcessorMongo(MongoCollectionFetcher fetcher) {this.mongoCollectionFetcher = fetcher;}

    /**
     * Saves a review to the database
     * @param review the review to be saved
     */
    @Override
    public String save(Review review) {
        Document newDoc = new Document("comment", review.getComment())
                .append("orderID", review.getOrderID())
                .append("picPathList", review.getPicPathList())
                .append("subjectLine", review.getSubjectLine())
                .append("lastEditTime", review.getLastEditTime())
                .append("rating", review.getRating());

        InsertOneResult result = this.mongoCollectionFetcher.getCollection("Reviews").insertOne(newDoc);

        return result.getInsertedId().asObjectId().getValue().toHexString();
    }

    /**
     * Creates a new review in the database
     * @param review the review to be created
     */
    @Override
    public String create(Review review) {
        return null;
    }

    /**
     * Finds all reviews in the database
     * @return a list of all reviews in the database
     */
    @Override
    public List<Review> findAll() {
        List<Review> reviews = new ArrayList<>();

        getReviewCollection()
                .find()
                .map(doc -> convertDocumentToReview((Document) doc))
                .forEach(review -> reviews.add((Review) review));

        return reviews;
    }

    private MongoCollection getReviewCollection(){
        return mongoCollectionFetcher.getCollection("Reviews");
    }

    private List<Review> findAllByQueryFilter(Bson queryFilter){
        List<Review> reviews = new ArrayList<>();

        getReviewCollection()
                .find(queryFilter)
                .map(doc -> convertDocumentToReview((Document) doc))
                .forEach(review -> reviews.add((Review) review));

        return reviews;
    }

    /**
     * Finds a review by id
     * @param id the id of a review
     * @return the review with the given id
     */
    @Override
    public Review findById(ObjectId id) {
        Bson filter = Filters.eq("_id", id);
        List<Review> result = findAllByQueryFilter(filter);
        if (result.size() > 0){
            return result.get(0);
        }
        else {return null;}
    }

    /**
     * Converts a document object to a review object
     * @param document the document to be converted
     * @return the review representation of the document
     */
    public static Review convertDocumentToReview(Document document) {
        List<Path> picPathList = document.getList("picPathList", String.class)
                .stream()
                .map(Paths::get)// Paths.get() method is applied to each string
                .collect(Collectors.toList());

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
     * @param review the review to be converted
     * @return the document representation of the review
     */
    public static Document convertReviewToDocument(Review review) {
        List<String> picPaths = review.getPicPathList()
                .stream() // a stream of Path objects
                .map(Path::toString)  // convert to a stream of strings
                .collect(Collectors.toList());  // collect into List

        return new Document("comment", review.getComment())  // no need for init ObjectId, as DB will auto-generate _id
                .append("orderID", review.getOrderID())
                .append("picPathList", picPaths)
                .append("subjectLine", review.getSubjectLine())
                .append("lastEditTime", review.getLastEditTime());
    }
}
