package entities;

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
}
