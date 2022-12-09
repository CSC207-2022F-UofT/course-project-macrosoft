package menu_editing_use_case;

import entities.*;
import org.bson.types.ObjectId;

//Application Business Rule layer

/**
 * This class is the request model for the add food use case.
 */
public class AddFoodRequestModel {

    private final ObjectId resId;
    private Menu curMenu;

    private String name;

    private String category;

    private String description;

    private float price;

    /**
     * Constructor for AddFoodRequestModel
     *
     * @param resId       the restaurant id
     * @param curMenu     the current menu
     * @param name        the name
     * @param category    the category
     * @param description the description
     * @param price       the price
     */
    public AddFoodRequestModel(ObjectId resId, Menu curMenu, String name, String category, String description, float price) {
        this.resId = resId;
        this.curMenu = curMenu;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    /**
     * Gets the current menu
     *
     * @return the current menu
     */
    public Menu getCurMenu() {
        return curMenu;
    }

    /**
     * Sets the current menu
     *
     * @param curMenu the current menu
     */
    public void setCurMenu(Menu curMenu) {
        this.curMenu = curMenu;
    }

    /**
     * Gets the restaurant name
     *
     * @return the restaurant name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the restaurant name
     *
     * @param name the restaurant name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the category
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category
     *
     * @param category the category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the description
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the price
     *
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the price
     *
     * @param price the price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Gets the restaurant id
     *
     * @return the restaurant id
     */
    public ObjectId getResId() {
        return resId;
    }
}

