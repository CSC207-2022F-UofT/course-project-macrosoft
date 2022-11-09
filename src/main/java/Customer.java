import org.bson.types.ObjectId;

import java.util.*;

public class Customer {
    private String name;
    private String email;
    private ObjectId userId;


    public Customer(String name, String email, ObjectId userId){
        this.name = name;
        this.email = email;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }


}
