package Entities;

import com.mongodb.DBObject;

public interface MongoDBConvertible {

    /** convert entity into BDObject that could be stored into MongoDB*/
    public DBObject convertToDBObject();
}
