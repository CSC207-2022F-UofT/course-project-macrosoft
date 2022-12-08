package user_view_menu_use_case;

import org.bson.types.ObjectId;

/**
 * This class is the request model of view menu use case.
 */
public class DisplayMenuRequestModel {

    private final ObjectId restId;

    /**
     * Constructor of DisplayMenuRequestModel.
     *
     * @param restId a restaurant id
     */
    public DisplayMenuRequestModel(ObjectId restId) {
        this.restId = restId;
    }

    /**
     * Gets restaurant id.
     *
     * @return a restaurant id
     */
    public ObjectId getRestId() {
        return restId;
    }
}
