package Entities;

import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;

import org.bson.types.ObjectId;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Date;
import java.util.List;

public class Review implements MongoDBConvertible{
    private ObjectId reviewID;
    private ObjectId orderID;
    private String comment;

    private List<Path> picPathList;
    private String subjectLine;

    private Date lastEditTime;

    public Review(ObjectId reviewID, ObjectId orderID, String comment, String subjectLine, List<Path> picPathList) {
        this.reviewID = reviewID;
        this.orderID = orderID;
        this.comment = comment;
        this.subjectLine = subjectLine;
        this.picPathList = picPathList;
        this.lastEditTime = new Date();
    }

    @Override
    public DBObject convertToDBObject() {
        return new BasicDBObject();
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
