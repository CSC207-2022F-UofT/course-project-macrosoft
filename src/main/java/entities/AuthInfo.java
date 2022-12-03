package entities;

import org.bson.types.ObjectId;

public class AuthInfo {
    private String username;
    private String password;

    private ObjectId userId;

    public AuthInfo(String username, String password, ObjectId userId) {
        this.username = username;
        this.password = password;
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }
}
