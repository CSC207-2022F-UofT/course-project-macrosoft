package datamodels;

import entities.Order;

import java.nio.file.Path;
import java.util.Date;
import java.util.List;

public class MakeReviewRequestModel {
    Order curOrder;

    private int rating;  // 0-10
    private String comment;
    private List<Path> picPathList;
    private String subjectLine;
    private Date lastEditTime;

    public MakeReviewRequestModel(Order curOrder, int rating, String comment, List<Path> picPathList, String subjectLine, Date lastEditTime) {
        this.curOrder = curOrder;
        this.rating = rating;
        this.comment = comment;
        this.picPathList = picPathList;
        this.subjectLine = subjectLine;
        this.lastEditTime = lastEditTime;
    }

    public Order getCurOrder() {
        return curOrder;
    }

    public void setCurOrder(Order curOrder) {
        this.curOrder = curOrder;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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
