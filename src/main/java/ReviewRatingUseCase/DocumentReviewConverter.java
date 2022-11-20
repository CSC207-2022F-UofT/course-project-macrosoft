package ReviewRatingUseCase;

import Entities.*;

import org.bson.Document;

import java.util.List;
import java.util.stream.Collectors;

import java.nio.file.Path;
import java.nio.file.Paths;


public class DocumentReviewConverter {
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
