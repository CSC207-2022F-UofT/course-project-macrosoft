package Interactors;

import Entities.Order;
import Entities.Review;

import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;
import org.springframework.validation.ObjectError;

import javax.naming.event.ObjectChangeListener;
import java.nio.file.Path;
import java.util.List;

public class ReviewInteractor {

    private static final DBConnection conn = new MongoConnection();

    /** rate an Order by setting a Review, change that data in MongoDB */
    public static void setOrderReview(Order order, String comment, String subjectLine, List<Path> picPathList) {

        if (order.hasReview()) {
            Review review = order.getReview();

            review.setOrderID(order.getOrderID());
            review.setComment(comment);
            review.setSubjectLine(subjectLine);
            review.setPicPathList(picPathList);
        } else {
            order.setReview(new Review(new ObjectId(), order.getOrderID(), comment, subjectLine, picPathList));
        }
        MongoCollection reviewCollection = conn.getCollection("Review");

    }
}
