package entities;

import org.bson.types.ObjectId;

import java.util.*;

/**
 * This class is the menu entity.
 */
public class Menu {

    private final List<Food> foodList;
    private ObjectId restaurantId;

    private final ObjectId menuId;

    /**
     * Constructor for Menu
     *
     * @param foodList     the list of food
     * @param restaurantId the restaurant id
     * @param menuId       the menu id
     */
    public Menu(List<Food> foodList, ObjectId restaurantId, ObjectId menuId) {
        this.foodList = foodList;
        this.restaurantId = restaurantId;
        this.menuId = menuId;
    }

    /**
     * Gets the list of food
     *
     * @return the list of food
     */
    public List<Food> getFoodList() {
        return foodList;
    }

    /**
     * Gets the restaurant id
     *
     * @return the restaurant id
     */
    public ObjectId getRestaurantId() {
        return restaurantId;
    }

    /**
     * Sets the restaurant id
     *
     * @param restaurantId the restaurant id
     */
    public void setRestaurantId(ObjectId restaurantId) {
        this.restaurantId = restaurantId;
    }

    /**
     * Gets the menu id
     *
     * @return the menu id
     */
    public ObjectId getMenuId() {
        return menuId;
    }

    /**
     * Adds food to the menu
     *
     * @param newFood the food to be added
     */
    public void addFoodItem(Food newFood) {
        this.foodList.add(newFood);
    }

    /**
     * Removes food from the menu
     *
     * @param delFood the food to be removed
     */
    public void removeFoodItem(ObjectId delFood) {
        Food food = findFood(delFood);
        this.foodList.remove(food);
    }

    /**
     * Finds the food in the menu by id
     *
     * @param foodId the food id
     * @return the food
     */
    public Food findFood(ObjectId foodId) {
        for (Food curFood : foodList) {
            if (curFood.getItemID().compareTo(foodId) == 0) {
                return curFood;
            }
        }
        return null;
    }
}


