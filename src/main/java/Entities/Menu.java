package Entities;

import org.bson.types.ObjectId;

import java.util.*;

public class Menu {

    private List<Food> foodList;
    private ObjectId restaurantId;

    private ObjectId menuId;


    public Menu(List<Food> foodList, ObjectId restaurantId, ObjectId menuId) {
        this.foodList = foodList;
        this.restaurantId = restaurantId;
        this.menuId = menuId;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public ObjectId getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(ObjectId restaurantId) {
        this.restaurantId = restaurantId;
    }

    public ObjectId getMenuId() {
        return menuId;
    }

    public void setMenuId(ObjectId menuId) {
        this.menuId = menuId;
    }

    public void addFoodItem(Food newFood){
        this.foodList.add(newFood);
    }

    public void removeFoodItem(Food delFood){
        this.foodList.remove(delFood);
    }

    public Food findFood(ObjectId foodId){
        for (Food curFood: foodList){
            if(curFood.getItemID().compareTo(foodId) == 0){
                return curFood;
            }
        }
        return null;
    }
}


