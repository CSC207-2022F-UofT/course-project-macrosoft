package change_user_info_use_case;

import database.MongoCollectionFetcher;
import database.UserDataGateway;
import database.UserDataProcessorMongo;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ChangeUserInfoTest {

    MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
    UserDataGateway gateway = new UserDataProcessorMongo(fetcher);

    ObjectId userId = new ObjectId("63781f990941287f25394116");
    ChangeUserInfoOutputBoundary changeUserInfoOutputBoundary = new ChangeUserInfoPresenter(null);
    ChangeUserInfoInputBoundary changeUserInfoInputBoundary = new ChangeUserInfoInteractor(changeUserInfoOutputBoundary);
    ChangeUserInfoController changeUserInfoController = new ChangeUserInfoController(
            changeUserInfoInputBoundary,
            userId);

    ChangeUserInfoScreenInterface changeUserInfoScreen = new ChangeUserInfoScreen(changeUserInfoController);
    @BeforeEach
    void setUp() {
        changeUserInfoOutputBoundary.setScreen(changeUserInfoScreen);
    }

    @AfterEach
    void tearDown() {
        changeUserInfoController.changeUserInfo("Inor", "Zhou", "yinuozhao959@gmail.com");
    }

    @Test
    void testChangeUserInfo(){
        changeUserInfoController.changeUserInfo("Yeeno", "Zhou", "yinuozhao959@gmail.com");
        Assertions.assertEquals(gateway.findById(userId).getFirstName(), "Yeeno");
    }
}