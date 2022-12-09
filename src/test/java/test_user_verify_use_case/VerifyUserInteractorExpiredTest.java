package test_user_verify_use_case;

import database.MongoCollectionFetcher;
import database.VerificationCodeDataGateway;
import database.VerificationCodeProcessorMongo;
import entities.VerificationCode;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import user_verify_use_case.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerifyUserInteractorExpiredTest {


    //setting up test document in the database
    @BeforeEach
    void setUp() {

        ObjectId userID = new ObjectId("638fd7e653160338d10413bb");
        long millis = System.currentTimeMillis();
        java.util.Date date = new java.util.Date(millis);
        java.util.Date new_date = AddMinutesInteractor.addMinutesToDate(-5, date);
        VerificationCode code = new VerificationCode(new_date, "898912");

        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        VerificationCodeDataGateway verificationCodeDataGateway = new VerificationCodeProcessorMongo(fetcher);
        verificationCodeDataGateway.save(userID, code);
    }

    // deleting the document from database after test is run
    @AfterEach
    void tearDown() {
        ObjectId userID = new ObjectId("638fd7e653160338d10413bb");
        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        VerificationCodeDataGateway verificationCodeDataGateway = new VerificationCodeProcessorMongo(fetcher);
        verificationCodeDataGateway.deleteByUserId(userID);
    }

    // testing verify user interactor with an expired code
    @Test
    void testVerifyUserExpired() {
        ObjectId userID = new ObjectId("638fd7e653160338d10413bb");
        int actual = 1002;
        VerifyUserOutputBoundary verifyUserOutputBoundary = new VerifyUserPresenter(null);
        VerifyUserFacade verifyUserFacade = new VerifyUserFacade(verifyUserOutputBoundary);
        VerifyUserController verifyUserController = new VerifyUserController(verifyUserFacade, userID);
        VerifyUserScreenInterface verifyUserScreen = new VerifyUserScreen(verifyUserController);

        verifyUserOutputBoundary.setVerifyUserScreen(verifyUserScreen);
        verifyUserScreen.getFrame().setVisible(true);

        VerifyUserInteractor verifyUserInteractor = new VerifyUserInteractor(verifyUserOutputBoundary);

        assertEquals(verifyUserInteractor.verifyUser(userID, "898912"), actual);

    }
}