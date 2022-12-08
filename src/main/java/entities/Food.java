package entities;

import org.bson.types.ObjectId;

/**
 * This class is the food entity.
 */
public class Food {
    private String name;
    private String description;
    private String category;
    private float price;
    private final ObjectId itemID;

    /**
     * Constructor for Food
     *
     * @param name        the name of the food
     * @param description the description of the food
     * @param category    the category of the food
     * @param price       the price of the food
     * @param itemID      the item id of the food
     */
    public Food(String name, String description, String category, float price, ObjectId itemID) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.itemID = itemID;
    }

    /**
     * Gets the name of the food
     *
     * @return the name of the food
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the food
     *
     * @param name the name of the food
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the food
     *
     * @return the description of the food
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the food
     *
     * @param description the description of the food
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the category of the food
     *
     * @return the category of the food
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the food
     *
     * @param category the category of the food
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the price of the food
     *
     * @return the price of the food
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the price of the food
     *
     * @param price the price of the food
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Gets the item id of the food
     *
     * @return the item id of the food
     */
    public ObjectId getItemID() {
        return itemID;
    }

}