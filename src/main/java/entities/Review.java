package entities;

import org.bson.types.ObjectId;
import java.nio.file.Path;

import java.util.Date;
import java.util.List;

public class Review{
    private ObjectId reviewID;
    private ObjectId orderID;
    private int rating;  // 0-10
    private String comment;
    private List<Path> picPathList;
    private String subjectLine;
    private Date lastEditTime;

    /** init a new Review with input Date*/
    public Review(ObjectId reviewID, ObjectId orderID, int rating, String comment, String subjectLine, List<Path> picPathList, Date lastEditTime) {
        this.reviewID = reviewID;
        this.orderID = orderID;
        this.rating = rating;
        this.comment = comment;
        this.subjectLine = subjectLine;
        this.picPathList = picPathList;
        this.lastEditTime = lastEditTime;
    }

    public ObjectId getReviewID() {
        return reviewID;
    }

    public void setReviewID(ObjectId reviewID) {
        this.reviewID = reviewID;
    }

    public ObjectId getOrderID() {
        return orderID;
    }

    public void setOrderID(ObjectId orderID) {
        this.orderID = orderID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Path> getPicPathList() {
        return picPathList;
    }

    public void setPicPathList(List<Path> picPathList) {
        this.picPathList = picPathList;
    }

    public String getSubjectLine() {
        return subjectLine;
    }

    public void setSubjectLine(String subjectLine) {
        this.subjectLine = subjectLine;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
