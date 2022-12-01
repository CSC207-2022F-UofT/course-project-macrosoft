package Database;

import Entities.Review;
import org.bson.types.ObjectId;

import java.util.List;

public interface ReviewDataGateway {
    String save(Review review);
    String delete(Review review);
    String create(Review review);
    List<Review> findAll();
    Review findByOrderId(ObjectId OrderId);
    Review findById(ObjectId id);
}
