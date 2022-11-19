import database_access.ConnectionManager;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import register_use_case.RegisterUserInteractor;

public class Main {
    public static void main(String[] args) {

        RegisterUserInteractor.registerUser("inorrrr", "123456", "Inor", "Zhou", "wowla");

    }

}
