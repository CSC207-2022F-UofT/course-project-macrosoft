package res_display_menu_usecase;
import org.bson.types.ObjectId;

/**
 * This class is the request model for the display menu use case.
 */
public class ResDisplayMenuRequestModel {

    private final ObjectId restId;

    /**
     * Constructor for ResDisplayMenuRequestModel
     *
     * @param restId the rest id
     */
    public ResDisplayMenuRequestModel(ObjectId restId) {
        this.restId = restId;
    }

    /**
     * Gets the rest id.
     *
     * @return the rest id
     */
    public ObjectId getRestId() {
        return restId;
    }
}
