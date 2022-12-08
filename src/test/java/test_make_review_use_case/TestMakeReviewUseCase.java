package test_make_review_use_case;

import database.MongoCollectionFetcher;
import database.ReviewDataGateway;
import database.ReviewDataProcessorMongo;
import entities.Review;
import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import user_make_review_use_case.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TestMakeReviewUseCase {
    @Before
    public void setup(){
    }

    /**
     * test if the MakeReviewUseCase saves the review input
     */
    @Test
    public void testMakeReview(){
        // setup input metrics
        ObjectId orderId = new ObjectId();
        int rating = 7;
        String comment = "this is a comment";
        List<Path> p = null;
        String subject = "this is a subject line";
        Date d = new Date();

        // run the use case
        MakeReviewPresenter presenter = new MakeReviewResponseFormatter();
        ReviewInteractor i = new ReviewInteractor(presenter);
        MakeReviewRequestModel request= new MakeReviewRequestModel(orderId, rating, comment, p, subject, d);
        i.makeReview(request);

        // check database to see if the review has been saved
        MongoCollectionFetcher f = new MongoCollectionFetcher();
        ReviewDataGateway g = new ReviewDataProcessorMongo(f);
        Review review = g.findByOrderId(orderId);

        assertTrue(review != null);
        assertTrue(review.getReviewID() != null);

        assertEquals(review.getOrderID(), orderId);
        assertEquals(review.getRating(), rating);
        assertEquals(review.getComment(), comment);
        assertEquals(review.getSubjectLine(), subject);
        assertEquals(review.getLastEditTime(), d);
        assertEquals(review.getPicPathList(), p);

    }

    @After
    public void teardown(){}

}
