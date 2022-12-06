package change_restaurant_info_use_case;

import org.bson.types.ObjectId;

public class TestChangeRestaurantInfoScreen {
    public static void main(String[] args) {
        ChangeRestaurantInfoPresenter changeRestaurantInfoPresenter = new ChangeRestaurantInfoProcessor(null);
        ChangeRestaurantInfoInputBoundary changeRestaurantInfoInputBoundary = new ChangeRestaurantInfoInteractor(changeRestaurantInfoPresenter);
        ChangeRestaurantInfoController changeRestaurantInfoController = new ChangeRestaurantInfoController(changeRestaurantInfoInputBoundary, new ObjectId("63504de50fd7682673870fde"));

        ChangeRestaurantInfoScreenInterface changeRestaurantInfoScreen = new ChangeRestaurantInfoScreen(changeRestaurantInfoController);

        changeRestaurantInfoPresenter.setScreen(changeRestaurantInfoScreen);

        changeRestaurantInfoScreen.getFrame().setVisible(true);
    }
}
