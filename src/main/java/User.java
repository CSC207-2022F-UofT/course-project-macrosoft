
import javax.management.ObjectName;
import java.util.*;

public class User {
    private String name;
    private String userId;
    private String email;


    public User(String name, String userId, String email){
        this.name = name;
        this.userId = userId;
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getid(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }
}
