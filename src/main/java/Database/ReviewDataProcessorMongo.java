package Database;

import Entities.Order;
import Entities.Review;
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

public class ReviewDataProcessorMongo implements ReviewDataGateway{
    MongoCollectionFetcher mongoCollectionFetcher;

    public ReviewDataProcessorMongo(MongoCollectionFetcher fetcher) {this.mongoCollectionFetcher = fetcher;}

    @Override
    public String save(Review review) {
        return null;
    }

    @Override
    public String delete(Review review) {
        return null;
    }

    @Override
    public String create(Review review) {
        return null;
    }

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

    @Override
    public Review findByOrderId(ObjectId OrderID) {
        Bson filter = Filters.eq("OrderID", OrderID);
        List<Review> result = findAllByQueryFilter(filter);
        if (result.size() > 0){
            return result.get(0);
        }
        else {return null;}
    }

    @Override
    public Review findById(ObjectId id) {
        Bson filter = Filters.eq("_id", id);
        List<Review> result = findAllByQueryFilter(filter);
        if (result.size() > 0){
            return result.get(0);
        }
        else {return null;}
    }

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
