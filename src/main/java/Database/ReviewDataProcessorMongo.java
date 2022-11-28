package Database;

import Entities.Review;
import org.bson.types.ObjectId;

import java.util.List;

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
        return null;
    }

    @Override
    public Review findByOrderId(ObjectId OrderId) {
        return null;
    }

    @Override
    public Review findById(ObjectId id) {
        return null;
    }
}
