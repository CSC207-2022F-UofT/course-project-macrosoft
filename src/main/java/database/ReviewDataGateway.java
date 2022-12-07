package database;

import entities.Review;
import org.bson.types.ObjectId;

import java.util.List;

public interface ReviewDataGateway {
    String save(Review review);
    String create(Review review);
    List<Review> findAll();
    Review findById(ObjectId id);
}
