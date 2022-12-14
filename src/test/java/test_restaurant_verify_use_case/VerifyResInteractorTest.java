package test_restaurant_verify_use_case;

import database.MongoCollectionFetcher;
import database.VerificationCodeDataGateway;
import database.VerificationCodeProcessorMongo;
import entities.VerificationCode;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restaurant_verify_use_case.*;


import static org.junit.jupiter.api.Assertions.*;

class VerifyResInteractorTest {


    // setting up a test document in our database
    @BeforeEach
    void setUp() {

        ObjectId resID = new ObjectId("638fd7e653160338d10413bb");
        long millis = System.currentTimeMillis();
        java.util.Date date = new java.util.Date(millis);
        VerificationCode code = new VerificationCode(date, "898912");

        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        VerificationCodeDataGateway verificationCodeDataGateway = new VerificationCodeProcessorMongo(fetcher);
        verificationCodeDataGateway.save(resID, code);
    }

    // removing the test document from database after tests are run
    @AfterEach
    void tearDown() {
        ObjectId resID = new ObjectId("638fd7e653160338d10413bb");
        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        VerificationCodeDataGateway verificationCodeDataGateway = new VerificationCodeProcessorMongo(fetcher);
        verificationCodeDataGateway.deleteByUserId(resID);
    }

    // testing verify restaurant interactor with a valid code
    @Test
    void testVerifyResValid() {
        ObjectId resID = new ObjectId("638fd7e653160338d10413bb");
        int actual = 1000;
        VerifyResOutputBoundary verifyResOutputBoundary = new VerifyResPresenter(null);
        VerifyResFacade verifyResFacade = new VerifyResFacade(verifyResOutputBoundary);
        VerifyResController verifyResController = new VerifyResController(verifyResFacade, resID);
        VerifyResScreenInterface verifyResScreen = new VerifyResScreen(verifyResController);

        verifyResOutputBoundary.setVerifyResScreenInterface(verifyResScreen);

        verifyResScreen.getFrame().setVisible(true);

        VerifyResInteractor verifyResInteractor = new VerifyResInteractor(verifyResOutputBoundary);
        assertEquals(verifyResInteractor.verifyRes(resID, "898912"), actual);

    }

    // testing verify Res interactor with an invalid code
    @Test
    void testVerifyResInvalid() {
        ObjectId resID = new ObjectId("638fd7e653160338d10413bb");
        int actual = 1001;
        VerifyResOutputBoundary verifyResOutputBoundary = new VerifyResPresenter(null);
        VerifyResFacade verifyResFacade = new VerifyResFacade(verifyResOutputBoundary);
        VerifyResController verifyResController = new VerifyResController(verifyResFacade, resID);
        VerifyResScreenInterface verifyResScreen = new VerifyResScreen(verifyResController);

        verifyResOutputBoundary.setVerifyResScreenInterface(verifyResScreen);
        verifyResScreen.getFrame().setVisible(true);

        VerifyResInteractor verifyResInteractor = new VerifyResInteractor(verifyResOutputBoundary);
        assertEquals(verifyResInteractor.verifyRes(resID, "898911"), actual);

    }
}