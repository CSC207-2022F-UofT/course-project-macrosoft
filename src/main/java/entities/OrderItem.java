package entities;

import org.bson.types.ObjectId;

/**
 * This class is the order item entity.
 */
public class OrderItem {
    private final ObjectId foodItemID;
    private Food food;
    private final int numberOfItem;

    /**
     * Constructor for OrderItem
     *
     * @param foodItemID   the food item id
     * @param food         the food
     * @param numberOfItem the number of item
     */
    public OrderItem(ObjectId foodItemID, Food food, int numberOfItem) {
        this.foodItemID = foodItemID;
        this.food = food;
        this.numberOfItem = numberOfItem;
    }

    /**
     * Gets the price of the order item
     *
     * @return the price of the order item
     */
    public float getPrice() {
        return this.food.getPrice() * this.numberOfItem;
    }

    /**
     * Gets the food item id
     *
     * @return the food item id
     */
    public ObjectId getFoodItemID() {
        return foodItemID;
    }

    /**
     * Gets the food
     *
     * @return the food
     */
    public Food getFood() {
        return food;
    }

    /**
     * \
     * Sets the food
     *
     * @param food the food
     */
    public void setFood(Food food) {
        this.food = food;
    }

    /**
     * Gets the number of item
     *
     * @return the number of item
     */
    public int getNumberOfItem() {
        return numberOfItem;
    }
}