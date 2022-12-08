package menu_editing_use_case;

// Application Business Rules Layer

import database.MenuDataGateway;
import database.MenuDataMongo;
import database.MongoCollectionFetcher;
import org.bson.types.ObjectId;

import entities.*;

/**
 * This class is the interactor for the add food use case.
 */
public class MenuEditingInteractor implements AddFoodInputBoundary, RemoveFoodInputBoundary {

    ObjectId resId;

    MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
    MenuDataGateway menuDataGateway = new MenuDataMongo(fetcher);

    /**
     * Constructor for MenuEditingInteractor
     *
     * @param resId the restaurant id
     */
    public MenuEditingInteractor(ObjectId resId) {
        this.resId = resId;
    }

    /**
     * Creates a new food item and adds it to the menu.
     *
     * @param requestModel the request model
     */
    @Override
    public void create(AddFoodRequestModel requestModel) {
        AddFoodHelper helper = new AddFoodHelper();
        Menu newMenu = helper.add(requestModel.getCurMenu(),
                requestModel.getName(),
                requestModel.getDescription(),
                requestModel.getCategory(),
                requestModel.getPrice());

        menuDataGateway.setMenu(requestModel.getResId(), newMenu);
    }

    /**
     * Removes a food item from the menu.
     *
     * @param requestModel the request model
     */
    @Override
    public void create(RemoveFoodRequestModel requestModel) {
        RemoveFoodHelper helper = new RemoveFoodHelper();
        Menu newMenu = helper.remove(requestModel.getCurMenu(), requestModel.getFoodToRemove());

        menuDataGateway.setMenu(requestModel.getResId(), newMenu);

    }

    /**
     * Gets the menu.
     *
     * @return the menu
     */
    public Menu getMenu() {
        return menuDataGateway.getMenu(resId);
    }

    /**
     * Gets the restaurant id.
     *
     * @return the restaurant id
     */
    @Override
    public ObjectId getResId() {
        return resId;
    }
}
